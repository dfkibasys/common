package de.dfki.cos.basys.common.component;

public interface ServiceProvider<T> {
	boolean connect(ComponentContext context, String connectionString);
	void disconnect();
	boolean isConnected();	
	T getService();
}
