package de.dfki.iui.basys.common.emf.json;

import java.io.IOException;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.dfki.iui.basys.model.domain.capability.CapabilityPackage;
import de.dfki.iui.basys.model.domain.capability.util.CapabilityResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.linebalancing.LinebalancingPackage;
import de.dfki.iui.basys.model.domain.linebalancing.util.LinebalancingResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.material.MaterialPackage;
import de.dfki.iui.basys.model.domain.material.util.MaterialResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.order.OrderPackage;
import de.dfki.iui.basys.model.domain.order.util.OrderResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.processdefinition.ProcessdefinitionPackage;
import de.dfki.iui.basys.model.domain.processdefinition.util.ProcessdefinitionResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.processinstance.ProcessinstancePackage;
import de.dfki.iui.basys.model.domain.processinstance.util.ProcessinstanceResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.productdefinition.ProductdefinitionPackage;
import de.dfki.iui.basys.model.domain.productdefinition.util.ProductdefinitionResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.productinstance.ProductinstancePackage;
import de.dfki.iui.basys.model.domain.productinstance.util.ProductinstanceResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.resourceinstance.ResourceinstancePackage;
import de.dfki.iui.basys.model.domain.resourceinstance.util.ResourceinstanceResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.resourcetype.ResourcetypePackage;
import de.dfki.iui.basys.model.domain.resourcetype.util.ResourcetypeResourceFactoryImpl;
import de.dfki.iui.basys.model.domain.topology.TopologyPackage;
import de.dfki.iui.basys.model.domain.topology.util.TopologyResourceFactoryImpl;
import de.dfki.iui.basys.model.runtime.component.ComponentPackage;

public class BasysResourceSetImpl extends ResourceSetImpl {
	
	Client client = ClientBuilder.newClient();
	
	public BasysResourceSetImpl() {
		
		getPackageRegistry().put(CapabilityPackage.eNS_URI,CapabilityPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("capability", new CapabilityResourceFactoryImpl());	
			
		getPackageRegistry().put(MaterialPackage.eNS_URI,MaterialPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("material", new MaterialResourceFactoryImpl());	
		
		getPackageRegistry().put(OrderPackage.eNS_URI,OrderPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("order", new OrderResourceFactoryImpl());
		
		getPackageRegistry().put(ProcessdefinitionPackage.eNS_URI,ProcessdefinitionPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("processdefinition", new ProcessdefinitionResourceFactoryImpl());
		
		getPackageRegistry().put(ProcessinstancePackage.eNS_URI,ProcessinstancePackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("processinstance", new ProcessinstanceResourceFactoryImpl());
		
		getPackageRegistry().put(ProductdefinitionPackage.eNS_URI,ProductdefinitionPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("productdefinition", new ProductdefinitionResourceFactoryImpl());
		
		getPackageRegistry().put(ProductinstancePackage.eNS_URI,ProductinstancePackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("productinstance", new ProductinstanceResourceFactoryImpl());
		
		getPackageRegistry().put(ResourceinstancePackage.eNS_URI,ResourceinstancePackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("resourceinstance", new ResourceinstanceResourceFactoryImpl());
		
		getPackageRegistry().put(ResourcetypePackage.eNS_URI,ResourcetypePackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("resourcetype",	new ResourcetypeResourceFactoryImpl());

		getPackageRegistry().put(TopologyPackage.eNS_URI,TopologyPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("topology", new TopologyResourceFactoryImpl());
		
		getPackageRegistry().put(LinebalancingPackage.eNS_URI,LinebalancingPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("linebalancing", new LinebalancingResourceFactoryImpl());
		
		getPackageRegistry().put(ComponentPackage.eNS_URI,ComponentPackage.eINSTANCE);
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("component", new XMIResourceFactoryImpl());
	
		
		//TODO: get real network endpoint or even urispec for each individual service from component registry
//		String BASE_URL = "http://localhost:8080/services/";
//		String fileName = "model";
//				
//		String [] fileExtensions = new String [] {"material", "order", "processdefinition", "processinstance", "productdefinition", "productinstance", "resourceinstance", "resourcetype", "topology" };
//		for (String fileExtension : Arrays.asList(fileExtensions)) {
//			getURIConverter().getURIMap().put(URI.createURI(fileName + "." + fileExtension), URI.createURI(BASE_URL + "entity"));			
//		}
				
		
	}
	
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		
		EObject obj = super.getEObject(uri, loadOnDemand);
		if (obj == null) {
			//call URL
			String url = uri.toString();
			Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();
			if (response.getStatus() == 200) {
				String content = response.readEntity(String.class);
				try {
					obj = JsonUtils.fromString(content, EObject.class);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return obj;
	}
	
}
