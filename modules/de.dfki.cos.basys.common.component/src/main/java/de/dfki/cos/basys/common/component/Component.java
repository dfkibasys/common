package de.dfki.cos.basys.common.component;

public interface Component {

	String getId();

	String getName();
	
	String getCategory();
	
	//ComponentConfiguration getConfig();
	
	ComponentInfo getInfo();
	
	void activate(ComponentContext context) throws ComponentException;

	void deactivate() throws ComponentException;
	
	boolean isActivated();	
	
	ServiceManager getServiceManager();
}
