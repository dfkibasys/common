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

public class ConnectionManagerImpl implements ConnectionManager {
	public final Logger LOGGER;
	protected Properties config;
	
	private boolean connected, observeConnection = false;
	private ScheduledFuture<?> connectionHandle = null;
	protected FunctionalClient client = null;

	private Supplier<? extends FunctionalClient> ctor;
	
	public ConnectionManagerImpl(Properties config, Supplier<? extends FunctionalClient> ctor) {
		this.LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
		this.ctor = Objects.requireNonNull(ctor);
		this.client = ctor.get();
		this.config = config;

		if (config.getProperty("observeExternalConnection") != null) {
			observeConnection = Boolean.parseBoolean(config.getProperty("observeExternalConnection"));
			LOGGER.info("observeExternalConnection = " + observeConnection);
		}	
	}
//	@Override	
//	public <T extends FunctionalClient> T getFunctionalClient() {
//		return (T)client;
//	}
//	
//	@Override
//	public <T extends FunctionalClient> T getFunctionalClient(Class<T> clazz) {
//		return clazz.cast(client);
//	}
//	
		
	@Override
	public void connect() throws ComponentException {
		if (!connected) {
			LOGGER.debug("connect");
			if (config.containsKey(Component.connectionString)) {
				String cs = config.getProperty(Component.connectionString);
				if (cs != null && !cs.equalsIgnoreCase("")) {
					if (client.connect(cs)) {
						LOGGER.debug("connect - finished");
						setConnected(true);
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
		if (connected) {
			LOGGER.debug("disconnect");
			if (client.disconnect()) {
				LOGGER.debug("disconnect - finished");
				setConnected(false);
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
		return connected;
	}

	protected void setConnected(boolean value) {
		connected = value;
//		if (observeConnection) {
//			if (connected) {
//				observeExternalConnection();
//			} else {
//				unobserveExternalConnection();
//			}
//		}
		notifyChange();
	}
	

	
	protected void notifyChange() {		
	}

	@Override
	public <T extends FunctionalClient> T getFunctionalClient(Class<T> clazz) {
		return clazz.cast(client);
	}

	@Override
	public FunctionalClient getFunctionalClient() {
		return client;
	}
	



	
//
//	private void observeExternalConnection() {
//		LOGGER.info("observeExternalConnection()");
//		connectionHandle = context.getScheduledExecutorService().scheduleWithFixedDelay(new Runnable() {
//
//			@Override
//			public void run() {
//
//				if (!isConnected()) {
//					LOGGER.info("connectToExternal: " + config.getExternalConnectionString());
//					try {
//						if (canConnect()) {
//							connect();
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
//	private void unobserveExternalConnection() {
//		LOGGER.info("unobserveConnection()");
//		connectionHandle.cancel(true);
//	}


}
