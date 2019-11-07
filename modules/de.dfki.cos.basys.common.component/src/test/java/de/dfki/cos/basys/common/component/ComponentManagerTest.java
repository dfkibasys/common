package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dfki.cos.basys.common.component.manager.ComponentManager;
import de.dfki.cos.basys.common.component.manager.ComponentManagerException;
import de.dfki.cos.basys.common.component.manager.impl.ComponentConfigurationProviderImpl;
import de.dfki.cos.basys.common.component.manager.impl.ComponentManagerImpl;

public class ComponentManagerTest {

	
	ComponentManagerImpl componentManager = null;		
	Properties config = null;
	
	@Before
	public void setUp() throws Exception {	
		config = new Properties();
		config.put(StringConstants.id, "component-manager");
		config.put(StringConstants.name, "component-manager");
		config.put(StringConstants.category, StringConstants.categoryManagement);
			
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFromFolder() throws ComponentException {
		config.put(StringConstants.connectionString, StringConstants.testConfigurationFolder);
		config.put("recursive", "true");

		componentManager = new ComponentManagerImpl(config);
		componentManager.activate(ComponentContext.getStaticContext());
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		assertEquals(6,componentManager.getComponents().size());
		
	}


	@Test
	public void testAddGetRemoveServiceComponent() throws ComponentException {

		componentManager = new ComponentManagerImpl(config);
		componentManager.activate(ComponentContext.getStaticContext());
		
		ComponentConfigurationProviderImpl client = new ComponentConfigurationProviderImpl();
		try {
			List<Component> components = componentManager.getComponents();
			assertEquals(0,components.size());

			Properties config1 = client.readFile(new File(StringConstants.testConfigurationFolder + "/component-1.json"));
			componentManager.createComponent(config1);
			components = componentManager.getComponents();
			assertEquals(1,components.size());

			Properties config2 = client.readFile(new File(StringConstants.testConfigurationFolder + "/component-2.json"));			
			componentManager.createComponent(config2);
			components = componentManager.getComponents();
			assertEquals(2,components.size());
			
			Properties config3 = client.readFile(new File(StringConstants.testConfigurationFolder + "/component-3.json"));			
			componentManager.createComponent(config3);			
			components = componentManager.getComponents();
			assertEquals(3,components.size());

			components = componentManager.getComponents();
			assertEquals(3,components.size());
			
			componentManager.deleteComponent("component-1");
			components = componentManager.getComponents();
			assertEquals(2,components.size());
			
			componentManager.deleteComponent("component-2");
			components = componentManager.getComponents();
			assertEquals(1,components.size());
	
			componentManager.deleteComponent("component-3");
			components = componentManager.getComponents();
			assertEquals(0,components.size());
	
		} catch (ComponentManagerException e) {
			e.printStackTrace();
			fail();
		}

	}
	
}
