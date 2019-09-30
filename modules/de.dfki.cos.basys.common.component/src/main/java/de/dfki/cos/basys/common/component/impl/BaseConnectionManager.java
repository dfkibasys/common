package de.dfki.cos.basys.common.component.impl;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ConnectionManager;

public class BaseConnectionManager implements ConnectionManager {
	public final Logger LOGGER;

	private boolean connected, observeConnection = false;

	private ScheduledFuture<?> connectionHandle = null;

	public BaseConnectionManager() {
		
		LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());

//		if (config.getProperties().get("observeExternalConnection") != null) {
//			observeConnection = Boolean.parseBoolean(config.getProperties().get("observeExternalConnection"));
//			LOGGER.info("observeExternalConnection = " + observeConnection);
//		}
	}

	@Override
	public void connect(String connectionString) throws ComponentException {
		setConnected(true);
	}

	@Override
	public void disconnect() throws ComponentException {
		setConnected(false);
	}

	@Override
	public boolean isConnected() {
		return connected;
	}

	private void setConnected(boolean value) {
		connected = value;
//		if (observeConnection) {
//			if (connected) {
//				observeExternalConnection();
//			} else {
//				unobserveExternalConnection();
//			}
//		}
//		notifyChange();
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
