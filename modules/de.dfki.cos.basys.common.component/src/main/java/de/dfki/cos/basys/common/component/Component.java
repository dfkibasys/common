package de.dfki.cos.basys.common.component;

public interface Component {

	String getId();
	
	String getName();
	
	//ComponentConfiguration getConfig();
	
	//ComponentInfo getComponentInfo();

	void activate(ComponentContext context) throws ComponentException;

	void deactivate() throws ComponentException;
	
	boolean isActivated();
	
	void connectToExternal() throws ComponentException;

	void disconnectFromExternal() throws ComponentException;
	
	boolean isConnectedToExternal();
	
}
