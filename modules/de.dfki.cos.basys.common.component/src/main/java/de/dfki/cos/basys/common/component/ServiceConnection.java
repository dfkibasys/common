package de.dfki.cos.basys.common.component;

public interface ServiceConnection {
	boolean connect(ComponentContext context, String connectionString);
	void disconnect();
	boolean isConnected();	
}
