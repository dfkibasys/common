package de.dfki.cos.basys.common.emf;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class EmfUtils {

	public static <T extends EObject> T clone(T eObject) {
		if (eObject instanceof EClass)
			return eObject;
		EmfCloner cloner = new EmfCloner();
		T clone = (T) cloner.copy(eObject);
		cloner.copyReferences();
		return clone;
	}

	public static Set<EPackage> collectSiamPackages(boolean includeCore) {
		Set<EPackage> result = new HashSet<EPackage>();

		// collect the siam core packages
		Object[] keys = EPackage.Registry.INSTANCE.keySet().toArray();
		for (int i = 0; i < keys.length; ++i) {
			String key = (String) keys[i];
			EPackage temp = EPackage.Registry.INSTANCE.getEPackage(key);
			EList<EAnnotation> eAnnotations = temp.getEAnnotations();
			for (EAnnotation ann : eAnnotations) {
				if (ann.getSource().equals("http://de.dfki.iui.mmds/CoreModel") && includeCore) {
					addPackage(result, temp);
					break;
				} else if (ann.getSource().equals("http://de.dfki.iui.mmds/ExtensionModel")) {
					addPackage(result, temp);
					break;
				}
			}
		}
		return result;
	}
	
	public static Set<EClass> collectSubTypes(EClass type, boolean includeAbstract) {
		Set<EClass> result = new HashSet<EClass>();
		Set<EPackage> siamPackages = collectSiamPackages(true);		
		for (EPackage pkg : siamPackages) {
			for (EClassifier cls : pkg.getEClassifiers()) {				
				if (cls instanceof EClass) {
					EClass c = (EClass)cls;
					if (type.isSuperTypeOf(c) && c.isAbstract() == includeAbstract) {
						result.add(c);
					}
				}
			}
		}		
		return result;
	}

	private static void addPackage(Set<EPackage> result, EPackage p) {
		result.add(p);
		for (EPackage subPackage : p.getESubpackages()) {
			addPackage(result, subPackage);
		}
	}
}
