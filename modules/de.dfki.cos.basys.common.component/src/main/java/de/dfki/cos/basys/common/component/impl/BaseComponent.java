package de.dfki.cos.basys.common.component.impl;

import java.util.Properties;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ComponentInfo;
import de.dfki.cos.basys.common.component.ConnectionManager;
import de.dfki.cos.basys.common.component.FunctionalClient;
import de.dfki.cos.basys.common.component.StringConstants;

public class BaseComponent implements Component {

	public final Logger LOGGER;
	protected Properties config;
	protected boolean activated = false;
	protected ComponentContext context;

	protected ConnectionManager connectionManager = null;
		
	public BaseComponent(Properties config) {
		this.config = config;
		LOGGER = LoggerFactory.getLogger("basys.component." + getName().replaceAll(" ", "-"));
		//connectionManager = new ConnectionManagerImpl(config,BaseFunctionalClient::new);
	}
	
	@Override
	public String getId() {
		return config.getProperty(StringConstants.id);
	}

	@Override
	public String getName() {		
		return config.getProperty(StringConstants.name);
	}
	
	@Override
	public String getCategory() {		
		return config.getProperty(StringConstants.category, "NONE");
	}
	
	@Override
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	@Override
	public void activate(ComponentContext context) throws ComponentException {
		LOGGER.info("activate");
		if (!activated) {
			
			if (context == null) {
				LOGGER.error("Context must not be null!");
				throw new ComponentException("Context must not be null!");
			}
			
			this.context = context;	
			
			if (connectionManager != null)
				connectionManager.connect(context);

			doActivate();		
			
			setActivated(true);
			LOGGER.info("activate - finished");
		} else {
			LOGGER.info("already activated");
		}
	}
	
	@Override
	public void deactivate() throws ComponentException {
		LOGGER.info("deactivate");
		if (activated) {
			
			doDeactivate();
			setActivated(false);
			
			if (connectionManager != null)
				connectionManager.disconnect();
			
			context = null;
			LOGGER.info("deactivate - finished");
		} else {
			LOGGER.info("already deactivated");
		}
	}

	protected void doActivate() throws ComponentException{ 
		//empty, override in derived classes if needed
	}

	protected void doDeactivate() throws ComponentException{ 
		//empty, override in derived classes if needed
	}

	@Override
	public boolean isActivated() {
		return activated;
	}
	
	private void setActivated(boolean value) {
		activated = value;
		notifyChange();
	}	

	public boolean isConnected() {
		return (connectionManager != null) ? connectionManager.isConnected() : false;
	}	
	
	protected void notifyChange() {
		//empty, override in derived classes if needed
	}

	@Override
	public ComponentInfo getInfo() {
		ComponentInfo info = new ComponentInfo()
				.setId(getId())
				.setName(getName())
				.setCategory(getCategory())
				.setActivated(isActivated())
				.setConnected(isConnected());
		return info;
	}



}
