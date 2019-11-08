package de.dfki.cos.basys.common.component.impl;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ComponentInfo;
import de.dfki.cos.basys.common.component.ConnectionManager;
import de.dfki.cos.basys.common.component.StringConstants;
import de.dfki.cos.basys.common.component.registry.ComponentRegistration;
import de.dfki.cos.basys.common.component.registry.ComponentRegistrationException;

public class BaseComponent implements Component {

	public final Logger LOGGER;
	protected Properties config;
	protected boolean activated = false;
	protected ComponentContext context;
	protected ComponentRegistration registration;

	protected ConnectionManager connectionManager = null;
		
	public BaseComponent(Properties config) {
		this.config = config;
		LOGGER = LoggerFactory.getLogger("basys.component." + getName().replaceAll(" ", "-"));
		
		if (config.containsKey(StringConstants.serviceConnectionString) && connectionManager != null) {
			connectionManager = new ConnectionManagerImpl(config);
		}		
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
			
			try {
				register();
			} catch (ComponentRegistrationException e) {
				throw new ComponentException(e);
			}
			
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
			try {
				unregister();
			} catch (ComponentRegistrationException e) {
				throw new ComponentException(e);
			}
			
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
	

	protected void register() throws ComponentRegistrationException {
		LOGGER.debug("register");
		if (context.getComponentRegistry() != null) {
			registration = context.getComponentRegistry().createRegistration(this);
			registration.register();
			LOGGER.debug("register - finished");
		} else {
			LOGGER.info("no component registry available");
		}
	}

	protected void unregister() throws ComponentRegistrationException {
		LOGGER.debug("unregister");
		if (registration != null) {
			registration.unregister();
			registration = null;
			LOGGER.debug("unregister - finished");
		} else {
			LOGGER.debug("not registered");
		}
	}
	
	public boolean isRegistered() {
		return registration != null;
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
		LOGGER.trace("notifyChange");
		// TODO: something like:Notification not = createStatusUpdate();

		//LOGGER.info(String.format("component '%s' (id=%s) is now in state %s and mode %s", getName(), getId(), getState(), getMode()));

//		if (statusChannel != null && statusChannel.isOpen()) {
//			LOGGER.trace("send status update notification");
//			try {
//				ComponentInfo info = getComponentInfo();
//				Notification not = cf.createNotification(JsonUtils.toString(info));
//				statusChannel.sendNotification(not);
//			} catch (ChannelException | JsonProcessingException e) {
//				LOGGER.warn("could not send status update notification");
//				LOGGER.warn(e.getMessage());
//				e.printStackTrace();
//			}
//		} else {
//			LOGGER.info("cannot send status update notification");
//		}
		if (registration != null) {
			try {
				LOGGER.trace("update registration");
				registration.update();
			} catch (ComponentRegistrationException e) {
				LOGGER.warn("could not update registration");
				LOGGER.warn(e.getMessage());
				e.printStackTrace();
			}
		} else {
			LOGGER.info("cannot update registration, not registered");
		}

		LOGGER.trace("notifyChange - finished");
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
