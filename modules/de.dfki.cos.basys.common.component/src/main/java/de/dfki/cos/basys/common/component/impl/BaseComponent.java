package de.dfki.cos.basys.common.component.impl;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentConfiguration;
import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentException;

public class BaseComponent implements Component {

	public final Logger LOGGER;
	protected ComponentConfiguration config;
	protected boolean activated = false;
	protected ComponentContext context;
	
	protected boolean connectedToExternal = false;
	protected boolean observeExternalConnection = false;
	private ScheduledFuture<?> externalConnectionHandle = null;
	
	public BaseComponent(ComponentConfiguration config) {
		this.config = config;
		LOGGER = LoggerFactory.getLogger("basys.component." + config.getName().replaceAll(" ", "-"));

		if (config.getProperties().get("observeExternalConnection") != null) {
			observeExternalConnection = Boolean.parseBoolean(config.getProperties().get("observeExternalConnection"));
			LOGGER.info("observeExternalConnection = " + observeExternalConnection);
		}
	}

	@Override
	public String getId() {
		return config.getId();
	}

	@Override
	public String getName() {		
		return config.getName();
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
			
			if (config.getExternalConnectionString() != null && !config.getExternalConnectionString().equals("")) {
								
				LOGGER.info("connectToExternal: " + config.getExternalConnectionString());
				try {
					if (canConnectToExternal()) {
						connectToExternal();
						setConnectedToExternal(true);
					} else {
						LOGGER.warn("component cannot connectToExternal(), skip ...");
					}
					LOGGER.debug("connectToExternal - finished");
				} catch (ComponentException e) {
					LOGGER.error(e.getMessage());
					LOGGER.warn("component could not connectToExternal()");
					//e.printStackTrace();
					setConnectedToExternal(false);
				}
				
				observeExternalConnection();
				
			}

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
			
			if (connectedToExternal) {				
				unobserveExternalConnection();
				disconnectFromExternal();
				setConnectedToExternal(false);
			}
			
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
	public void connectToExternal() {
		//empty, override in derived classes if needed
	}
	
	@Override
	public void disconnectFromExternal() {
		//empty, override in derived classes if needed
	}
	
	protected boolean canConnectToExternal() throws ComponentException {
		//return always true, override in derived classes if needed
		return true;
	}
	@Override
	public boolean isActivated() {
		return activated;
	}
	
	private void setActivated(boolean value) {
		activated = value;
		notifyChange();
	}	

	@Override
	public boolean isConnectedToExternal() {
		return connectedToExternal;
	}
	
	private void setConnectedToExternal(boolean value) {
		connectedToExternal = value;
		notifyChange();
	}

	private void observeExternalConnection() {
		if (observeExternalConnection) {
			LOGGER.info("observeExternalConnection()");
			externalConnectionHandle = context.getScheduledExecutorService().scheduleWithFixedDelay(new Runnable() {
				
				@Override
				public void run() {			
					
					if (!isConnectedToExternal()) {
						LOGGER.info("connectToExternal: " + config.getExternalConnectionString());
						try {
							if (canConnectToExternal()) {
								connectToExternal();
								//connectedToExternal = true;
							} else {
								LOGGER.warn("component cannot connectToExternal(), retry ...");
							}
							LOGGER.debug("connectToExternal - finished");
						} catch (ComponentException e) {
							LOGGER.error(e.getMessage());
							LOGGER.warn("component could not connectToExternal(), retry ...");
							e.printStackTrace();
						}
					}
					
				}
				
			}, 5000, 5000, TimeUnit.MILLISECONDS);
		}				
	}
	
	private void unobserveExternalConnection() {
		if (observeExternalConnection) {
			LOGGER.info("unobserveExternalConnection()");
			externalConnectionHandle.cancel(true);
		}
	}
	
	protected void notifyChange() {
		//empty, override in derived classes if needed
	}



}
