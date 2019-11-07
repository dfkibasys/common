package de.dfki.cos.basys.common.component.impl;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ServiceConnection;

public class BaseBackendConnection implements ServiceConnection {

	boolean connected = false;
	
	@Override
	public boolean connect(ComponentContext context, String connectionString) {
		connected = true;
		return connected;
	}

	@Override
	public void disconnect() {
		connected = false;		
	}

	@Override
	public boolean isConnected() {
		return connected;
	}

}
