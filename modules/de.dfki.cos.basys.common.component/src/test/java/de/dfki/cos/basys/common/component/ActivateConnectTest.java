package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dfki.cos.basys.common.component.util.TestComponent;

public class ActivateConnectTest {

	Properties config;
	TestComponent component;
	
	String user_a = "user_a";
	String user_b = "user_b";
	
	@Before
	public void setUp() throws Exception {		
		config = new Properties();
		config.put(StringConstants.id, "test-component");
		config.put(StringConstants.name, "test-component");	
		component = new TestComponent(config);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivateDeactivate() {
		try {
			assertFalse(component.isActivated());
			//assertFalse(component.isConnectedToExternal());
			component.activate(ComponentContext.getStaticContext());
			assertTrue(component.isActivated());
			//assertFalse(component.isConnectedToExternal());
			component.deactivate();
			assertFalse(component.isActivated());
			//assertFalse(component.isConnectedToExternal());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConnectDisconnectServiceProvider() {
		try {
			config.put(StringConstants.serviceConnectionString, "somewhere"); // must not be null or empty for this test
			
			assertFalse(component.isActivated());
			assertFalse(component.getServiceManager().isConnected());
			component.activate(ComponentContext.getStaticContext());
			assertTrue(component.isActivated());
			
			assertTrue(component.getServiceManager().isConnected());
			
			component.deactivate();
			assertFalse(component.isActivated());
			assertFalse(component.getServiceManager().isConnected());
		} catch (Exception e) {
			fail();
		}
	}
	
//	@Test
//	public void testObserveExternalConnection() {
//		try {
//			assertFalse(component.isActivated());
//			assertFalse(component.isConnectedToExternal());
//			component.activate();
//			assertTrue(component.isActivated());
//			assertFalse(component.isConnectedToExternal());
//			
//			
//			
//			
//			
//			component.deactivate();
//			assertFalse(component.isActivated());
//			assertFalse(component.isConnectedToExternal());
//		} catch (Exception e) {
//			fail();
//		}
//	}
	
}
