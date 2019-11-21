package de.dfki.cos.basys.common.aas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.eclipse.basyx.aas.metamodel.map.AssetAdministrationShell;
import org.eclipse.basyx.aas.metamodel.map.descriptor.AASDescriptor;
//import org.eclipse.basyx.aas.metamodel.map.descriptor.SubmodelDescriptor;
import org.eclipse.basyx.aas.metamodel.map.parts.Asset;
import org.eclipse.basyx.aas.registration.api.IAASRegistryService;
import org.eclipse.basyx.aas.registration.memory.InMemoryRegistry;
import org.eclipse.basyx.aas.registration.proxy.AASRegistryProxy;
import org.eclipse.basyx.aas.registration.restapi.DirectoryModelProvider;
import org.eclipse.basyx.aas.restapi.AASModelProvider;
import org.eclipse.basyx.aas.restapi.VABMultiSubmodelProvider;
import org.eclipse.basyx.submodel.metamodel.map.SubModel;
import org.eclipse.basyx.submodel.metamodel.map.identifier.IdentifierType;
import org.eclipse.basyx.submodel.metamodel.map.qualifier.Description;
import org.eclipse.basyx.submodel.metamodel.map.qualifier.haskind.Kind;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.operation.Operation;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.operation.OperationVariable;
import org.eclipse.basyx.submodel.restapi.SubModelProvider;
import org.eclipse.basyx.vab.modelprovider.api.IModelProvider;
import org.eclipse.basyx.vab.protocol.http.server.AASHTTPServer;
import org.eclipse.basyx.vab.protocol.http.server.BaSyxContext;
import org.eclipse.basyx.vab.protocol.http.server.VABHTTPInterface;

import de.dfki.cos.basys.common.aas.dto.AasDescriptor;
import de.dfki.cos.basys.common.aas.dto.Endpoint;
import de.dfki.cos.basys.common.aas.dto.SubmodelDescriptor;

public class AasTest {

	public static void main(String[] args) {
		
		IAASRegistryService registryService = new InMemoryRegistry();
		
		/* Ein Servlet aufbauen und das Directory einbinden */
		BaSyxContext context_reg = new BaSyxContext("", "", "localhost", 4999);
		
		context_reg.addServletMapping("/*", new VABHTTPInterface<IModelProvider>(new DirectoryModelProvider(registryService)));
		/* Das Servlet auf einem Server ablegen und Server starten */
		AASHTTPServer registryServer = new AASHTTPServer(context_reg);
		registryServer.start();
		
		
		// TODO Auto-generated method stub
		AssetAdministrationShell aas = new AssetAdministrationShell();
		aas.setIdentification(IdentifierType.Custom, "whatsoeverAssId");
		aas.setIdShort("aas");
		aas.setAdministration("1.0", "0");
		aas.setDescription(new Description("de-DE", "Test AAS"));

		Asset asset = new Asset();
		asset.setKind(Kind.Instance);
		asset.setIdentification(IdentifierType.Custom, "whatsoeverAssetId");
		asset.setIdShort("my_asset");

		aas.setAsset(asset);

		System.out.println(aas);

		/* Das Teilmodell erzeugen, IdShort und Identification setzen */
		SubModel tighteningControl = new SubModel();
		tighteningControl.setIdShort("TighteningControl");
		tighteningControl.setIdentification(IdentifierType.Custom, "tighteningControlSubModel");

		/* Die Operation erzeugen und die IdShort setzen */
		Operation tightenOp = new Operation();
		tightenOp.setIdShort("tighten");

		/* Die Eingangsvariablen konfigurieren */
		OperationVariable programNoOV = new OperationVariable();
		programNoOV.setIdShort("ProgramNo");
		programNoOV.setType("String");

		OperationVariable timesOV = new OperationVariable();
		timesOV.setIdShort("Times");
		timesOV.setType("Integer");

		/* ... und in der Operation ablegen */
		List<OperationVariable> in = new ArrayList<>();
		in.add(programNoOV);
		in.add(timesOV);

		tightenOp.SetParameterTypes(in);

		/* Die Ausgangsvariable konfigurieren */
		OperationVariable ret = new OperationVariable();
		ret.setIdShort("TighteningSuccess");
		ret.setType("Boolean");

		/* ... und in der Operation ablegen */
		tightenOp.setReturnTypes(Collections.singletonList(ret));

		/* Die Funktion für den Schrauberzugriff als Lambda-Funktion definieren */
		Function<Object[], Object> func = (arg) -> {

			/* Die Parameter entpacken */
			String programNo = (String) arg[0];
			int times = (int) arg[1];
			return null;
			/* Das Backend des TighteningService erstellen */
			// TighteningService tighteningService = new TighteningService();
			/* ... und die Funktion aufrufen */
			// return tighteningService.tightenTimes(programNo, times);
		};

		/* Die Lambda-Funktion in der Operation hinterlegen */
		tightenOp.setInvocable(func);

		/* ... und die Operation in dem Teilmodell ablegen */
		tighteningControl.addSubModelElement(tightenOp);

		

		System.out.println(tighteningControl);
		
		
		
		/* Die Verwaltungsschale in einem Provider ablegen */
		VABMultiSubmodelProvider provider = new VABMultiSubmodelProvider(new AASModelProvider(aas));
		SubModelProvider subProvider =  new SubModelProvider(tighteningControl);
		/* ... und ihre Teilmodelle ebenfalls  */
		provider.addSubmodel("TighteningControl", subProvider);
		//provider.addSubmodel("TechnicalSpecification", new SubModelProvider(technicalSpecification));

		/* Ein Servlet aufbauen und den Provider einbinden */
		BaSyxContext context = new BaSyxContext("", "", "localhost", 5080);
		context.addServletMapping("/*", new VABHTTPInterface<IModelProvider>(provider));

		/* Das Servlet auf einem Server ablegen und den Server starten */
		AASHTTPServer httpServer = new AASHTTPServer(context);
		httpServer.start();
		
		/* Den Verwaltungsschalendeskriptor erzeugen und den Endpunkt/die Adresse festlegen */
		AASDescriptor aasDescriptor = new AASDescriptor(aas, "http://192.168.178.13:5080/aas");

		AasDescriptor aasDesc = new AasDescriptor(aas, new Endpoint("http", "http://192.168.178.13:5080/aas"));
		SubmodelDescriptor subDesc = new SubmodelDescriptor(tighteningControl, new Endpoint("http", "http://localhost:5080/aas/submodels/" + tighteningControl.getIdShort()));
		/* Die Teilmodelldeskriptoren mit den jeweiligen Endpunkten erstellen und dem Verwaltungsschalendeskriptor hinzufügen */
		//aasDescriptor.addSubmodelDescriptor(new SubmodelDescriptor(tighteningControl, "http://localhost:5080/aas/submodels/" + tighteningControl.getIdShort()));
		//aasDescriptor.addSubmodelDescriptor(new SubmodelDescriptor(tighteningControl, "http://localhost:5080/aas/submodels/" + tighteningControl.getIdShort() + "/submodel"));
		//aasDescriptor.addSubmodelDescriptor(new SubmodelDescriptor(technicalSpecification, "http:// localhost:5080/aas/submodels/" + technicalSpecification.getIdShort() + "/submodel"));
		
		registryService.register(aasDescriptor);
		
		/* Den Registry-Proxy über den Endpunkt erstellen */
//		AASRegistryProxy registry = new AASRegistryProxy("http://localhost:4999/");
//
//		/* ... und die Verwaltungsschale registrieren */
//		registry.register(aasDescriptor);
		
		String connectionString = "lns-90165.sb.dfki.de:2181";
		
		ZookeeperAasRegistry reg = new ZookeeperAasRegistry();
		reg.connect(connectionString);
		//reg.createAasNode(aasDesc);
		
		try {
			Thread.sleep(1000*60*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reg.disconnect();
		
	}

}
