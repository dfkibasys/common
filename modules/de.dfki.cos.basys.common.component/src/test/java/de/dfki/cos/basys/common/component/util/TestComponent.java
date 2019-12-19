package de.dfki.cos.basys.common.component.util;

import java.util.Properties;

import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ServiceProvider;
import de.dfki.cos.basys.common.component.impl.BaseComponent;
import de.dfki.cos.basys.common.component.impl.ServiceComponent;
import de.dfki.cos.basys.common.component.impl.ServiceManagerImpl;

public class TestComponent extends ServiceComponent<Void> {
	
	public TestComponent(Properties config) {
		super(config, new BaseBackendConnection());		
	
	}

	public TestComponent(Properties config, ServiceProvider<Void> serviceProvider) {
		super(config, serviceProvider);				
	}
}
