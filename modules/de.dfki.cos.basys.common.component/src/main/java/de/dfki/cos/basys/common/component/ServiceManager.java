package de.dfki.cos.basys.common.component;

public interface ServiceManager {
	
	void connect(ComponentContext context) throws ComponentException;
	void disconnect() throws ComponentException;	
	boolean isConnected();
	ServiceConnection getServiceConnection();
	
	<T> T getServiceInterface(Class<T> serviceInterface);
	
	void handleConnectionEstablished();
	void handleConnectionLost();
	void handleConnectionClosed();
}
