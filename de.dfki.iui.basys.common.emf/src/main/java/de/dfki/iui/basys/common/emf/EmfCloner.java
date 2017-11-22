package de.dfki.iui.basys.common.emf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;

//import de.dfki.iui.mmds.core.emf.datatypes.BDataType;

public class EmfCloner extends Copier {

	HashSet<EObject> alreadyCopied = new HashSet<EObject>();

	@Override
	public void copyReferences() {
		List<EObject> eObjects = new ArrayList<EObject>();
		eObjects.addAll(keySet());
		for (int i = 0; i < eObjects.size(); ++i) {
			EObject eObject = eObjects.get(i);
			if (alreadyCopied.contains(eObject)) {
				continue;
			} else {
				alreadyCopied.add(eObject);
			}
			EObject copyEObject = get(eObject);
			EClass eClass = eObject.eClass();
			for (int j = 0, size = eClass.getFeatureCount(); j < size; ++j) {
				EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(j);
				if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived()) {
					if (eStructuralFeature instanceof EReference) {
						EReference eReference = (EReference) eStructuralFeature;
						if (!eReference.isContainment() && !eReference.isContainer()) {
							copyReference(eReference, eObject, copyEObject);
						}
					} else if (FeatureMapUtil.isFeatureMap(eStructuralFeature)) {
						FeatureMap featureMap = (FeatureMap) eObject.eGet(eStructuralFeature);
						FeatureMap copyFeatureMap = (FeatureMap) copyEObject.eGet(getTarget(eStructuralFeature));
						int copyFeatureMapSize = copyFeatureMap.size();
						for (int k = 0, featureMapSize = featureMap.size(); k < featureMapSize; ++k) {
							EStructuralFeature feature = featureMap.getEStructuralFeature(k);
							if (feature instanceof EReference) {
								Object referencedEObject = featureMap.getValue(k);
								Object copyReferencedEObject = get(referencedEObject);
								if (copyReferencedEObject == null && referencedEObject != null) {
									EReference reference = (EReference) feature;
									if (!useOriginalReferences || reference.isContainment() || reference.getEOpposite() != null) {
										continue;
									}
									copyReferencedEObject = referencedEObject;
								}
								// If we can't add it, it must already be in the
								// list so find it and move it to the end.
								//
								if (!copyFeatureMap.add(feature, copyReferencedEObject)) {
									for (int l = 0; l < copyFeatureMapSize; ++l) {
										if (copyFeatureMap.getEStructuralFeature(l) == feature && copyFeatureMap.getValue(l) == copyReferencedEObject) {
											copyFeatureMap.move(copyFeatureMap.size() - 1, l);
											--copyFeatureMapSize;
											break;
										}
									}
								}
							} else {
								copyFeatureMap.add(featureMap.get(k));
							}
						}
					}
				}
			}
		}
	}

//	@Override
//	protected void copyAttributeValue(EAttribute eAttribute, EObject eObject, Object value, EStructuralFeature.Setting setting) {
//		if (value instanceof BDataType) {
//			try {
//				BDataType<?> newValue = (BDataType<?>) value.getClass().newInstance();
//				newValue.setValue(value.toString());
//				value = newValue;
//			} catch (InstantiationException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		setting.set(value);
//	}

	/**
	 * Called to handle the copying of a cross reference; this adds values or
	 * sets a single value as appropriate for the multiplicity while omitting
	 * any bidirectional reference that isn't in the copy map.
	 * 
	 * @param eReference
	 *            the reference to copy.
	 * @param eObject
	 *            the object from which to copy.
	 * @param copyEObject
	 *            the object to copy to.
	 */
	@Override
	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eReference)) {
			if (eReference.isMany()) {
				@SuppressWarnings("unchecked")
				InternalEList<EObject> source = (InternalEList<EObject>) eObject.eGet(eReference);
				@SuppressWarnings("unchecked")
				InternalEList<EObject> target = (InternalEList<EObject>) copyEObject.eGet(getTarget(eReference));
				if (source.isEmpty()) {
					target.clear();
				} else {
					boolean isBidirectional = eReference.getEOpposite() != null;
					int index = 0;
					for (Iterator<EObject> k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();) {
						EObject referencedEObject = k.next();
						EObject copyReferencedEObject;
						if (referencedEObject.eClass().getEPackage() instanceof EcorePackage) {
							copyReferencedEObject = referencedEObject;
						} else {
							copyReferencedEObject = get(referencedEObject);
						}
						if (copyReferencedEObject == null) {
							if (referencedEObject instanceof EObject) {
								EObject copy = copy(referencedEObject);
								copyReferences();
								target.addUnique(index, copy);
								++index;
							} else {
								System.out.println();
							}
						} else {
							if (isBidirectional) {
								int position = target.indexOf(copyReferencedEObject);
								if (position == -1) {
									target.addUnique(index, copyReferencedEObject);
								} else if (index != position) {
									target.move(index, copyReferencedEObject);
								}
							} else {
								target.addUnique(index, copyReferencedEObject);
							}
							++index;
						}
					}
				}
			} else {
				EObject referencedEObject = (EObject) eObject.eGet(eReference, resolveProxies);
				if (referencedEObject == null) {
					copyEObject.eSet(getTarget(eReference), null);
				} else {
					Object copyReferencedEObject;
					if (referencedEObject.eClass().getEPackage() instanceof EcorePackage) {
						copyReferencedEObject = referencedEObject;
					} else {
						copyReferencedEObject = get(referencedEObject);
					}
					if (copyReferencedEObject == null) {
						if (referencedEObject instanceof EObject) {
							EObject copy = copy(referencedEObject);
							copyReferences();
							copyEObject.eSet(getTarget(eReference), copy);
						} else {
							System.out.println();
							// if (useOriginalReferences &&
							// eReference.getEOpposite() == null)
							// {
							// copyEObject.eSet(getTarget(eReference),
							// referencedEObject);
							// }
						}
					} else {
						copyEObject.eSet(getTarget(eReference), copyReferencedEObject);
					}
				}
			}
		}
	}
}
