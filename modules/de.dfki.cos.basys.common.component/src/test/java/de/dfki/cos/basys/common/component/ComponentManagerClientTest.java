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

	
	ComponentConfigurationProviderImpl provider;
	
	@Before
	public void setUp() throws Exception {			
		provider = new ComponentConfigurationProviderImpl();			
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadJsonConfig() throws ComponentException {
		Properties config = provider.readFile(new File(StringConstants.testConfigurationFolder + "/component-1.json"));
		assertEquals("component-1",config.getProperty("id"));
	}
	
	@Test
	public void testReadPropertiesConfig() throws ComponentException {
		Properties config = provider.readFile(new File(StringConstants.testConfigurationFolder + "/recursive/component-6.properties"));
		assertEquals("component-6",config.getProperty("id"));		
	}

	@Test
	public void testPaths() throws ComponentException {
		provider.connect(null, StringConstants.testConfigurationFolder);
		List<String> configs = provider.getComponentConfigurationPaths();
		assertEquals(3, configs.size());
	}
	
	@Test
	public void testReadConfigurations() throws ComponentException {
		provider.connect(null, StringConstants.testConfigurationFolder);
		List<String> configs = provider.getComponentConfigurationPaths();				
		assertEquals(3, configs.size());
		
		for (String path : configs) {
			Properties config = provider.getComponentConfiguration(path);
			assertNotNull(config);
		}		
	}
	
	@Test
	public void testPathsRecursive() throws ComponentException {
		provider.setRecursive(true);
		provider.connect(null, StringConstants.testConfigurationFolder);
		List<String> configs = provider.getComponentConfigurationPaths();
		assertEquals(6, configs.size());				
	}
	
}
