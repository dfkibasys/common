package de.dfki.cos.basys.common.component;

public interface ConnectionManager {
	
	void connect(ComponentContext context) throws ComponentException;
	void disconnect() throws ComponentException;	
	boolean isConnected();
	<T extends FunctionalClient> T getFunctionalClient(Class<T> clazz);
	FunctionalClient getFunctionalClient();
	
	void handleConnectionEstablished();
	void handleConnectionLost();
	void handleConnectionClosed();
}
