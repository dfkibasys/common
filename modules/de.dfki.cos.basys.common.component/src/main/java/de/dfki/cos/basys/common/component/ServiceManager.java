package de.dfki.cos.basys.common.component;

public interface ServiceManager<T> {
	
	void connect(ComponentContext context) throws ComponentException;
	void disconnect() throws ComponentException;	
	boolean isConnected();
	
	ServiceProvider<T> getServiceProvider();	
	T getService();
	T getServiceMockup();
	
	//void handleConnectionEstablished();
	//void handleConnectionLost();
	//void handleConnectionClosed();
}
