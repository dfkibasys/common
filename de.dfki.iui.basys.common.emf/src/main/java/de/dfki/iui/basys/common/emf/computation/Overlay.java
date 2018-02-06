package de.dfki.iui.basys.common.emf.computation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dfki.iui.basys.common.emf.EmfUtils;

public class Overlay extends Computation {

	static public EObject compute(EObject co, EObject bg) {
		return (EObject) new Overlay()._compute(co, bg);
	}

	@Override
	protected Object _compute(Object co, Object bg) {
		if (co instanceof EObject && bg instanceof EObject)
			return overlay((EObject) co, (EObject) bg);
		else
			return co;
	}

	private EObject overlay(EObject co, EObject bg) {
		// we don't want to overlay EClasses
		if (co instanceof EClass || bg instanceof EClass)
			throw new IllegalArgumentException("Overlay of Eclasses");

		if (co == bg)
			return EmfUtils.clone(co);
		else if (co == null && bg == null)
			return null;
		else if (co == null)
			return EmfUtils.clone(bg);
		else if (bg == null)
			return EmfUtils.clone(co);

		EObject resultFromAlreadyHandled = resultFromAlreadyHandled(co, bg);

		if (resultFromAlreadyHandled != null)
			return resultFromAlreadyHandled;

		EObject target;
		EObject filler;

		if (bg != null && co.eClass().isSuperTypeOf(bg.eClass())) {
			target = EcoreUtil.copy(bg);
			filler = co;
		} else {
			target = EcoreUtil.copy(co);
			filler = bg;
		}

		addToAlreadyHandled(co, bg, target);

		Set<EStructuralFeature> features = getLeastUpperBoundFeatures(co, bg, false);

		for (EStructuralFeature feature : features) {
			if (!feature.isChangeable()) {
				continue;
			}
			if (feature instanceof EReference) {

				if (feature.isMany()) {
					List tmp = _overlay((List) co.eGet(feature), (List) bg.eGet(feature));
					target.eSet(feature, tmp); // EList
				} else {
					EObject tmp = overlay((EObject) co.eGet(feature), (EObject) bg.eGet(feature));
					if (tmp != null) {
						target.eSet(feature, tmp);
					}
				}
			} else /* if (feature instanceof EAttribute) */ {
				if (feature.isMany() && filler.eIsSet(feature)) {
					List<Object> eGet = (List<Object>) filler.eGet(feature);
					for (Object c : eGet) {
						if (!((List<Object>) target.eGet(feature)).contains(c)) {
							((List<Object>) target.eGet(feature)).add(c);
						}
					}
				} else {
					if (co.eIsSet(feature) && co.eGet(feature) != null) {
						target.eSet(feature, co.eGet(feature));
					} else if (bg.eIsSet(feature) && bg.eGet(feature) != null) {
						target.eSet(feature, bg.eGet(feature));
					}
				}
			}
		}

		return target;
	}

	private List<EObject> _overlay(List<EObject> co, List<EObject> bg) {
		List<EObject> result = new LinkedList<EObject>();

		int c = Integer.max(co.size(), bg.size());

		for (int i = 0; i < c; ++i) {
			if (i >= co.size()) {
				result.add(EmfUtils.clone(bg.get(i)));
			} else if (i >= bg.size()) {
				result.add(EmfUtils.clone(co.get(i)));
			} else {
				result.add(overlay(co.get(i), bg.get(i)));
			}
		}

		return result;
	}
}
