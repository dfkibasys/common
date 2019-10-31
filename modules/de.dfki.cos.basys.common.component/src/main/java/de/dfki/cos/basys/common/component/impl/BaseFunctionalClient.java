package de.dfki.cos.basys.common.component.impl;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.FunctionalClient;

public class BaseFunctionalClient implements FunctionalClient {

	@Override
	public boolean connect(ComponentContext context, String connectionString) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return true;
	}

}
