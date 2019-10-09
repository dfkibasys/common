package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dfki.cos.basys.common.component.impl.ComponentManagerImpl;

public class ComponentManagerTest {

	
	ComponentManager manager = null;	
	
	@Before
	public void setUp() throws Exception {	
		Properties config = new Properties();
		config.put(StringConstants.id, "component-manager");
		config.put(StringConstants.name, "component-manager");
		config.put(StringConstants.connectionString, "src/test/resources/components");
		config.put("recursive", "true");
		
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
