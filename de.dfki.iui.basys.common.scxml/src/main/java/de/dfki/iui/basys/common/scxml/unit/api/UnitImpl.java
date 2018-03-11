package de.dfki.iui.basys.common.scxml.unit.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.iui.basys.common.scxml.TestUnit;

public abstract class UnitImpl implements Unit {

	private String id;

	boolean initialized = false;

	PackML packml = null;
	
	UnitConfiguration config;
	
	protected final Logger LOGGER = LoggerFactory.getLogger(TestUnit.class.getName());

	///////////////////////////////

	public UnitImpl(String id) {
		this.id = id;
		packml = new PackML(this);
	}

	public void initialize() {
		packml.initialize();
	}

	public void dispose() {
		packml.dispose();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public State getState() {		
		return packml.getState();
	}
	
	@Override
	public Mode getMode() {
		return packml.getMode();
	}

	@Override
	public void changeMode(Mode mode) {
		packml.changeMode(mode);
	}

	@Override
	public UnitConfiguration getConfig() {
		return config;
	}
	
	@Override
	public void setConfig(UnitConfiguration config) {
		if (getState() == State.IDLE) {
			this.config = config;
			updateConfig();			
		}		
	}
	
	public abstract void updateConfig();
	
	@Override
	public void reset() {
		LOGGER.info("reset");
		packml.raiseLifecycleEvent("reset");
	}

	@Override
	public void start() {
		LOGGER.info("start");
		packml.raiseLifecycleEvent("start");
	}

	@Override
	public void stop() {
		LOGGER.info("stop");
		packml.raiseLifecycleEvent("stop");
	}

	@Override
	public void hold() {
		LOGGER.info("hold");
		packml.raiseLifecycleEvent("hold");
	}

	@Override
	public void unhold() {
		LOGGER.info("unhold");
		packml.raiseLifecycleEvent("unhold");
	}

	@Override
	public void suspend() {
		LOGGER.info("suspend");
		packml.raiseLifecycleEvent("suspend");
	}

	@Override
	public void unsuspend() {
		LOGGER.info("unsuspend");
		packml.raiseLifecycleEvent("unsuspend");
	}

	@Override
	public void abort() {
		LOGGER.info("abort");
		packml.raiseLifecycleEvent("abort");
	}

	@Override
	public void clear() {
		LOGGER.info("clear");
		packml.raiseLifecycleEvent("clear");
	}

	//Default Wait State Implementation
	
	public void onStopped() {
		LOGGER.info("onStopped");		
	};
	
	public void onIdle() {
		LOGGER.info("onIdle");		
	};
	
	public void onComplete() {
		LOGGER.info("onComplete");		
	};
	
	public void onHold() {
		LOGGER.info("onHold");		
	};
	
	public void onSuspend() {
		LOGGER.info("onSuspend");		
	};
	
	public void onAborted() {
		LOGGER.info("onAborted");		
	};

}
