package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dfki.cos.basys.common.component.ComponentOrderStatus;
import de.dfki.cos.basys.common.component.impl.ConnectionManagerImpl;
import de.dfki.cos.basys.common.component.util.TestComponent;

public class ActivateConnectTest {

	Properties config;
	TestComponent component;
	
	String user_a = "user_a";
	String user_b = "user_b";

	ComponentOrderStatus status = null;	
	
	@Before
	public void setUp() throws Exception {		
		config = new Properties();
		config.put(Component.id, "test-component");
		config.put(Component.name, "test-component");	
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
	public void testConnectDisconnectToExternal() {
		try {
			config.put(Component.connectionString, "somewhere");
			
			assertFalse(component.isActivated());
			assertFalse(component.getConnectionManager().isConnected());
			component.activate(ComponentContext.getStaticContext());
			assertTrue(component.isActivated());
			
			assertTrue(component.getConnectionManager().isConnected());
			
			component.deactivate();
			assertFalse(component.isActivated());
			assertFalse(component.getConnectionManager().isConnected());
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
