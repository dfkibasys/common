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

public class ComponentManagerClientTest {

	
	ComponentConfigurationProviderImpl  client;
	
	@Before
	public void setUp() throws Exception {			
		client = new ComponentConfigurationProviderImpl();			
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadJsonConfig() throws ComponentException {
		Properties config = client.readFile(new File(StringConstants.testConfigurationFolder + "/component-1.json"));
		assertEquals("component-1",config.getProperty("id"));
	}
	
	@Test
	public void testReadPropertiesConfig() throws ComponentException {
		Properties config = client.readFile(new File(StringConstants.testConfigurationFolder + "/recursive/component-6.properties"));
		assertEquals("component-6",config.getProperty("id"));		
	}

	@Test
	public void testReadFolder() throws ComponentException {
		client.connect(null, StringConstants.testConfigurationFolder);
		List<Properties> configs = client.getComponentConfigurations();
		assertEquals(3, configs.size());
	}
	
	@Test
	public void testReadFolderRecursive() throws ComponentException {
		client.setRecursive(true);
		client.connect(null, StringConstants.testConfigurationFolder);
		List<Properties> configs = client.getComponentConfigurations();
		assertEquals(6, configs.size());				
	}
	
}
