package de.dfki.iui.basys.common.emf.computation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dfki.iui.basys.common.emf.EmfUtils;
//import de.dfki.iui.basys.model.base.BasePackage;

public class Unification extends Computation {

	static public EObject compute(EObject co, EObject bg) {
		return (EObject) new Unification()._compute(co, bg);
	}

	@Override
	protected Object _compute(Object co, Object bg) {
		if (co instanceof EObject && bg instanceof EObject)
			return unify((EObject) co, (EObject) bg, false);
		else if (co.equals(bg))
			return co;
		else
			return null;
	}

	private EObject unify(EObject co, EObject bg, boolean reuseBg) {
		// we don't want to unify EClasses
		if (co instanceof EClass || bg instanceof EClass)
			return null;

		EObject resultFromAlreadyHandled = resultFromAlreadyHandled(co, bg);
		if (resultFromAlreadyHandled != null)
			return resultFromAlreadyHandled;

		EObject target = EmfUtils.clone(co);
		addToAlreadyHandled(co, bg, target);

		if (co == bg)
			return target;

		Set<EStructuralFeature> features = getLeastUpperBoundFeatures(co, bg, true);

		if (features.isEmpty())
			return null;

		for (EStructuralFeature feature : features) {

			if (!(feature.getEType() instanceof EEnum) && !bg.eIsSet(feature)) {
				continue;
			}

			if (feature instanceof EReference) {
				if (!feature.isChangeable())
					continue;
				if (feature.isMany()) {
					// List tmp = _unify((List) co.eGet(feature), (List)
					// bg.eGet(feature), reuseBg);
					List tmp = unify((List) co.eGet(feature), (List) bg.eGet(feature), reuseBg);
					if (tmp == null)
						return null;
					target.eSet(feature, tmp); // EList
				} else {
					if (!target.eIsSet(feature)) {
						target.eSet(feature, EmfUtils.clone((EObject) bg.eGet(feature)));
					} else {
						EObject tmp = unify((EObject) co.eGet(feature), (EObject) bg.eGet(feature), reuseBg);
						if (tmp == null)
							return null;
						target.eSet(feature, tmp); // EObject
					}

				}
			} else /* if (feature instanceof EAttribute) */ {
				if (feature.isMany()) {
					// unify the lists
					List<Object> unified = unify((List) co.eGet(feature), (List) bg.eGet(feature), reuseBg);
					if (unified == null)
						return null;
					target.eSet(feature, unified);
				} else {
					if (!(feature.getEType() instanceof EEnum) && !co.eIsSet(feature)) {
						target.eSet(feature, bg.eGet(feature)); // atomic data
																// type
					//} else if (feature.getEType() == BasePackage.eINSTANCE.getBString() && bg.eGet(feature).toString().equals("")) {
					} else if (feature.getEType().getName().equals("BString") && bg.eGet(feature).toString().equals("")) {
						// do nothing, because an empty BString is handled like
						// null strings
					} else if (bg.eIsSet(feature) && !co.eGet(feature).equals(bg.eGet(feature)))
						return null;
				}
			}
		}
		return target;
	}

	private List<Object> unify(List<Object> co, List<Object> bg, boolean reuseBg) {
		List<Object> result = new LinkedList<Object>();

		if (co.size() == 0 && bg.size() > 0) {
			for (Object bg_object : bg) {
				if (bg_object instanceof EObject)
					result.add(EmfUtils.clone((EObject) bg_object));
				else
					result.add(bg_object);
			}
		} else if (bg.size() == 0 && co.size() > 0) {
			for (Object co_object : co) {
				if (co_object instanceof EObject)
					result.add(EmfUtils.clone((EObject) co_object));
				else
					result.add(co_object);
			}
		}

		else {
			List<Object> unusedBg = new ArrayList<>(bg);
			List<Object> usedBg = new ArrayList<>(co.size());
			for (Object co_object : co) {
				Object[] res_bg = null;

				if (co_object.getClass().getName().equals("PSlot")) {
					
				} else if (co_object instanceof EObject)
					res_bg = getUnifiableObject((EObject) co_object, bg, reuseBg);
				else
					res_bg = getMatchingObject(co_object, bg, reuseBg);

				if (res_bg == null) {
					result.add(co_object);
				} else {
					usedBg.add(res_bg[1]);
					result.add(res_bg[0]);
				}
			}

			unusedBg.removeAll(usedBg);
			result.addAll(unusedBg);
		}
		return result;
	}

	private Object[] getMatchingObject(Object co, List<Object> bg_list, boolean reuseBg) {
		for (int i = 0; i < bg_list.size(); ++i) {
			Object bg = bg_list.get(i);
			Object result = null;
			if (co.equals(bg))
				result = co;
			if (result != null) {
				if (!reuseBg) {
					// in this case the background object will not be used for
					// further unifications
					bg_list.remove(bg);
				}
				return new Object[] { result, bg }; // bg has to be returned as
				// well to be able to
				// include unused bg
				// objects
			}
		}
		return null;
	}

	private EObject[] getUnifiableObject(EObject co, List<Object> bg_list, boolean reuseBg) {
		for (int i = 0; i < bg_list.size(); ++i) {
			EObject bg = (EObject) bg_list.get(i);
			EObject result = unify(co, bg, reuseBg);
			if (result != null) {
				if (!reuseBg) {
					// in this case the background object will not be used for
					// further unifications
					bg_list.remove(bg);
				}
				return new EObject[] { result, bg }; // bg has to be returned as
				// well to be able to
				// include unused bg
				// objects
			}
		}
		return null;
	}

}
