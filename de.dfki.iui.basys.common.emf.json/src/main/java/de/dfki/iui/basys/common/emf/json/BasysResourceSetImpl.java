package de.dfki.iui.basys.common.emf.json;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class BasysResourceSetImpl extends ResourceSetImpl {

	
	
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		
		EObject obj = super.getEObject(uri, loadOnDemand);
		if (obj == null) {
			//call URL
		}
		return obj;
	}
	
}
