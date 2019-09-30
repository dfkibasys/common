package de.dfki.cos.basys.common.component.util;

import java.util.Properties;

import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.impl.BaseComponent;
import de.dfki.cos.basys.common.component.impl.BaseConnectionManager;

public class TestComponent extends BaseComponent {
	
	public TestComponent(Properties properties) {
		super(properties);		
		this.connectionManager = new BaseConnectionManager();
	}

}
