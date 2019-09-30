package de.dfki.cos.basys.common.component;

public interface Component {

	final String id = "id";
	final String name = "name";
	final String implementationJavaClass = "implementationJavaClass";
	final String connectionString = "externalConnectionString";
	
	String getId();
	
	String getName();
	
	//ComponentConfiguration getConfig();
	
	//ComponentInfo getComponentInfo();
	
	void activate(ComponentContext context) throws ComponentException;

	void deactivate() throws ComponentException;
	
	boolean isActivated();	
	
	ConnectionManager getConnectionManager();
}
