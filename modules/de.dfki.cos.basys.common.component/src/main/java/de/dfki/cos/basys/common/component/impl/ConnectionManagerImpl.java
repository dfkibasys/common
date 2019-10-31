package de.dfki.cos.basys.common.component.impl;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ConnectionManager;
import de.dfki.cos.basys.common.component.FunctionalClient;
import de.dfki.cos.basys.common.component.StringConstants;

public class ConnectionManagerImpl implements ConnectionManager {
	public final Logger LOGGER;
	protected Properties config;
	private ComponentContext context = null;
	
	private boolean observeConnection = false;
	private ScheduledFuture<?> connectionHandle = null;
	protected FunctionalClient client = null;

	private Supplier<? extends FunctionalClient> ctor;
	
	public ConnectionManagerImpl(Properties config, Supplier<? extends FunctionalClient> ctor) {
		this.config = config;
		this.LOGGER = LoggerFactory.getLogger("basys.component." + getName().replaceAll(" ", "-"));		
		this.ctor = Objects.requireNonNull(ctor);
		this.client = ctor.get();

		if (config.getProperty("observeConnection") != null) {
			observeConnection = Boolean.parseBoolean(config.getProperty("observeConnection"));
			LOGGER.info("observeConnection = " + observeConnection);
		}	
	}
	
	private String getName() {		
		return config.getProperty(StringConstants.name) + ".ConnectionManager";
	}
	
//	@Override	
//	public <T extends FunctionalClient> T getFunctionalClient() {
//		return (T)client;
//	}

	@Override
	public <T extends FunctionalClient> T getFunctionalClient(Class<T> clazz) {
		return clazz.cast(client);
	}

	@Override
	public FunctionalClient getFunctionalClient() {
		return client;
	}
	
	@Override
	public void connect(ComponentContext context) throws ComponentException {
		this.context = context;
		if (!isConnected()) {
			LOGGER.debug("connect");
			if (config.containsKey(StringConstants.connectionString)) {
				String cs = config.getProperty(StringConstants.connectionString);
				if (cs != null && !cs.equalsIgnoreCase("")) {
					LOGGER.debug("provided connection string: " + cs);
					if (client.connect(context, cs)) {
						LOGGER.debug("connect - finished");
						//setConnected(true);
					} else {
						LOGGER.warn("connect - not successful");
					}
				} else {
					LOGGER.debug("connect - skipped due to empty connection string");
				}
			} else {
				LOGGER.debug("connect - skipped due to missing connection string");
			}			
		} else {
			LOGGER.info("already connected");
		}
	}

	@Override
	public void disconnect() throws ComponentException {
		if (isConnected()) {
			LOGGER.debug("disconnect");
			client.disconnect();
			if (!client.isConnected()) {
				LOGGER.debug("disconnect - finished");
				//setConnected(false);
			} else {
				LOGGER.warn("disconnect - not successful");
			}
		} else {
			LOGGER.info("already disconnected");
		}
	}

	protected boolean doConnect( ) {
		return true;
	}
	
	protected boolean doDisconnect( ) {
		return true;
	}
	
	@Override
	public boolean isConnected() {
		return getFunctionalClient().isConnected();
	}

//	protected void setConnected(boolean value) {
//		connected = value;
//		if (observeConnection) {
//			if (connected) {
//				observeConnection();
//			} else {
//				unobserveConnection();
//			}
//		}
//		notifyChange();
//	}
	

	
//	protected void notifyChange() {		
//	}
	

//	private void observeConnection() {
//		LOGGER.info("observeConnection()");
//		connectionHandle = context.getScheduledExecutorService().scheduleWithFixedDelay(new Runnable() {
//
//			@Override
//			public void run() {
//
//				if (!isConnected()) {
//					String cs = config.getProperty(StringConstants.connectionString);
//					LOGGER.info("connectToExternal: " + cs);
//					try {
//						if (canConnect()) {
//							connect(context);
//							// connectedToExternal = true;
//						} else {
//							LOGGER.warn("component cannot connectToExternal(), retry ...");
//						}
//						LOGGER.debug("connectToExternal - finished");
//					} catch (ComponentException e) {
//						LOGGER.error(e.getMessage());
//						LOGGER.warn("component could not connectToExternal(), retry ...");
//						e.printStackTrace();
//					}
//				}
//
//			}
//
//		}, 5000, 5000, TimeUnit.MILLISECONDS);
//
//	}
//
//	protected void unobserveConnection() {
//		LOGGER.info("unobserveConnection()");
//		if (connectionHandle != null) {
//			connectionHandle.cancel(true);
//		}
//	}

	@Override
	public void handleConnectionEstablished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleConnectionLost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleConnectionClosed() {
		// TODO Auto-generated method stub
		
	}


}
