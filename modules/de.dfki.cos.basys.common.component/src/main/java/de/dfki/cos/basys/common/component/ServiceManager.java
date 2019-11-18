package de.dfki.cos.basys.common.component;

public interface ServiceManager<T> {
	
	void connect(ComponentContext context) throws ComponentException;
	void disconnect() throws ComponentException;	
	boolean isConnected();
	ServiceConnection getServiceConnection();
	
	T getServiceInterface();
	
	//void handleConnectionEstablished();
	//void handleConnectionLost();
	//void handleConnectionClosed();
}
