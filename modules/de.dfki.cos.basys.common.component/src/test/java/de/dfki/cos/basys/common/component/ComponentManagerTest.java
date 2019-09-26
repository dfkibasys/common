package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dfki.cos.basys.common.component.impl.ComponentManagerImpl;

public class ComponentManagerTest {

	ComponentConfiguration config = new ComponentConfiguration.Builder()
			.id("component-manager")
			.name("component-manager")
			.externalConnectionString("src/test/resources/components")
			.implementationJavaClass("de.dfki.cos.basys.common.component.impl.ComponentManagerImpl")
			.addProperty("recursive", "true")
			.build();
	
	ComponentManager manager = null;	
	
	@Before
	public void setUp() throws Exception {	
		manager = new ComponentManagerImpl(config);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivate() throws ComponentException {
		
		manager.activate(ComponentContext.getStaticContext());
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		assertEquals(5,manager.getComponents().size());
		
	}

}
