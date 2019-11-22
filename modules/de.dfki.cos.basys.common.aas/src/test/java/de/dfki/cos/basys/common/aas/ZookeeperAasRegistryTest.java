package de.dfki.cos.basys.common.aas;

import static org.junit.Assert.*;

import java.util.Collections;

import org.eclipse.basyx.submodel.metamodel.map.identifier.IdentifierType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dfki.cos.basys.common.aas.registry.dto.AasDescriptor;
import de.dfki.cos.basys.common.aas.registry.dto.Endpoint;
import de.dfki.cos.basys.common.aas.registry.dto.Identifier;
import de.dfki.cos.basys.common.aas.registry.dto.SubmodelDescriptor;
import de.dfki.cos.basys.common.aas.registry.server.ZookeeperAasRegistry;

public class ZookeeperAasRegistryTest {

	String connectionString = "lns-90165.sb.dfki.de:2181";
	
	ZookeeperAasRegistry registry;
	AasDescriptor aas;
	SubmodelDescriptor sm1, sm2;
	@Before
	public void setUp() throws Exception {
		registry= new ZookeeperAasRegistry();
		registry.connect(connectionString);
		
		aas = new AasDescriptor();
		aas.setIdShort("myAas2");
		aas.setIdentification(new Identifier(IdentifierType.Custom, "myAas"));
		aas.setEndpoints(Collections.singletonList(new Endpoint("http", "http://localhost")));

		sm1 = new SubmodelDescriptor();
		sm1.setIdShort("mySubmodel1");
		sm1.setIdentification(new Identifier(IdentifierType.Custom, "mySubmodel1"));
		sm1.setEndpoints(Collections.singletonList(new Endpoint("http", "http://localhost/sm1")));

		sm2 = new SubmodelDescriptor();
		sm2.setIdShort("mySubmodel2");
		sm2.setIdentification(new Identifier(IdentifierType.Custom, "mySubmodel2"));
		sm2.setEndpoints(Collections.singletonList(new Endpoint("http", "http://localhost/sm2")));
		
		aas.getSubmodels().add(sm1);	
	}

	@After
	public void tearDown() throws Exception {
		registry.disconnect();
	}

	@Test
	public void testRegisterAas() {
		assertTrue(registry.isConnected());
		
		registry.registerAas(aas);
		
		registry.registerAasSubmodel(aas.getIdShort(), sm2);
		
		
	}

}
