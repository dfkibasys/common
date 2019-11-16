package de.dfki.cos.basys.common.component.util;

import java.util.Properties;

import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.impl.BaseComponent;
import de.dfki.cos.basys.common.component.impl.BaseBackendConnection;
import de.dfki.cos.basys.common.component.impl.ServiceManagerImpl;

public class TestComponent extends BaseComponent {
	
	public TestComponent(Properties config) {
		super(config);		
		connectionManager = new ServiceManagerImpl(config, BaseBackendConnection::new);	
	}

}
