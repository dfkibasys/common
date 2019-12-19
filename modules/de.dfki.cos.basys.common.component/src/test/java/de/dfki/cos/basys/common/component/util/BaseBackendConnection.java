package de.dfki.cos.basys.common.component.util;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ServiceProvider;

public class BaseBackendConnection implements ServiceProvider<Void> {

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

	@Override
	public Void getService() {
		return null;
	}

}
