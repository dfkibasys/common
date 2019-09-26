package de.dfki.cos.basys.common.component.util;

import de.dfki.cos.basys.common.component.ComponentConfiguration;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.impl.BaseComponent;

public class TestComponent extends BaseComponent {

	public TestComponent(ComponentConfiguration config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connectToExternal() {
		LOGGER.info("CONNECTED");
	}

	@Override
	public void disconnectFromExternal() {
		LOGGER.info("DISCONNECTED");
	}

}
