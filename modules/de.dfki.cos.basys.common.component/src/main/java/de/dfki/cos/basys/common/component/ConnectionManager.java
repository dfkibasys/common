package de.dfki.cos.basys.common.component;

public interface ConnectionManager {
	
	void connect(String connectionString) throws ComponentException;
	void disconnect() throws ComponentException;	
	boolean isConnected();
}
