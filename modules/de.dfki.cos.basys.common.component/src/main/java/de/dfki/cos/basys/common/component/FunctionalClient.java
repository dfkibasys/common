package de.dfki.cos.basys.common.component;

public interface FunctionalClient {
	boolean connect(ComponentContext context, String connectionString);
	void disconnect();
	boolean isConnected();	
}
