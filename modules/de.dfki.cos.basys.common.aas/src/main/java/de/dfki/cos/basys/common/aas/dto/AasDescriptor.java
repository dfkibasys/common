package de.dfki.cos.basys.common.aas.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.basyx.aas.metamodel.api.IAssetAdministrationShell;
import org.eclipse.basyx.aas.metamodel.map.AssetAdministrationShell;
import org.eclipse.basyx.submodel.metamodel.api.ISubModel;

public class AasDescriptor extends Descriptor {

	List<SubmodelDescriptor> submodels = new ArrayList<>();
	
	public AasDescriptor() {
		
	}
	
	public AasDescriptor(IAssetAdministrationShell aas, Endpoint endpoint) {
		this.idShort = aas.getIdShort();
		this.identification = new Identifier(aas.getIdentification());
		this.endpoints.add(endpoint);
		//for (HashMap<String, String> endpoint : aas.getEndpoints()) {
		//	this.endpoints.add(new Endpoint(endpoint.get(AssetAdministrationShell.TYPE),
		//			endpoint.get(AssetAdministrationShell.ADDRESS)));
		//}
				
//		for (ISubModel submodel : aas.getSubModels().values()) {
//			submodels.add(new SubmodelDescriptor(submodel, new Endpoint(endpoint.getType(), endpoint.getAddress() + "/submodels/"+submodel.getIdShort())));
//		}
	}

	public List<SubmodelDescriptor> getSubmodels() {
		return submodels;
	}
	
	public void setSubmodels(List<SubmodelDescriptor> submodels) {
		this.submodels = submodels;
	}
}
