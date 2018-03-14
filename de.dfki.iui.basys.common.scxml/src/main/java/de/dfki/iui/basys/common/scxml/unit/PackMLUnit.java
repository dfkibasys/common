package de.dfki.iui.basys.common.scxml.unit;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.iui.basys.common.scxml.TestHandler;

public class PackMLUnit implements StatusInterface, CommandInterface, ActiveStatesHandler, WaitStatesHandler {

	protected final Logger LOGGER = LoggerFactory.getLogger(TestHandler.class.getName());
	
	private String id;

	private boolean initialized = false;

	private PackML packml = null;
	
	private UnitConfiguration config;	

	private ActiveStatesHandler actHandler = null;
	private WaitStatesHandler waitHandler = null;
	
	public PackMLUnit(String id) {
		this.id = id;
		packml = new PackML(this);
	}
	
	public void initialize() {
		packml.initialize();
	}

	public void dispose() {
		packml.dispose();
	}
	
	public void setActiveStatesHandler(ActiveStatesHandler actHandler) {
		this.actHandler = actHandler;
	}
	
	public void setWaitStatesHandler(WaitStatesHandler waitHandler) {
		this.waitHandler = waitHandler;
	}
	
	/*
	 * StatusInterface
	 */

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
	public UnitConfiguration getConfig() {
		return config;
	}
	

	/*
	 * CommandInterface
	 */

	@Override
	public synchronized void setMode(Mode mode) {
		packml.setMode(mode);
	}

	@Override
	public synchronized void setConfig(UnitConfiguration config) {
		if (getState() == State.IDLE) {
			this.config = config;
		}		
	}

	@Override
	public synchronized void reset() {
		LOGGER.info("reset");
		packml.raiseLifecycleEvent("reset");
	}

	@Override
	public synchronized void start() {
		LOGGER.info("start");
		packml.raiseLifecycleEvent("start");
	}

	@Override
	public synchronized void stop() {
		LOGGER.info("stop");
		packml.raiseLifecycleEvent("stop");
	}

	@Override
	public synchronized void hold() {
		LOGGER.info("hold");
		packml.raiseLifecycleEvent("hold");
	}

	@Override
	public synchronized void unhold() {
		LOGGER.info("unhold");
		packml.raiseLifecycleEvent("unhold");
	}

	@Override
	public synchronized void suspend() {
		LOGGER.info("suspend");
		packml.raiseLifecycleEvent("suspend");
	}

	@Override
	public synchronized void unsuspend() {
		LOGGER.info("unsuspend");
		packml.raiseLifecycleEvent("unsuspend");
	}

	@Override
	public synchronized void abort() {
		LOGGER.info("abort");
		packml.raiseLifecycleEvent("abort");
	}

	@Override
	public synchronized void clear() {
		LOGGER.info("clear");
		packml.raiseLifecycleEvent("clear");
	}
	
	/*
	 * ActiveStatesHandler facade
	 */
	
	@Override
	public void onResetting() {
		LOGGER.info("onResetting");
		if (actHandler != null)
			actHandler.onResetting();
	}

	@Override
	public void onStarting() {
		LOGGER.info("onStarting");
		if (actHandler != null)
			actHandler.onStarting();
	}

	@Override
	public void onExecute() {
		LOGGER.info("onExecute");
		if (actHandler != null)
			actHandler.onExecute();
	}

	@Override
	public void onCompleting() {
		LOGGER.info("onCompleting");
		if (actHandler != null)
			actHandler.onCompleting();
	}

	@Override
	public void onHolding() {
		LOGGER.info("onHolding");
		if (actHandler != null)
			actHandler.onHolding();
	}

	@Override
	public void onUnholding() {
		LOGGER.info("onUnholding");
		if (actHandler != null)
			actHandler.onUnholding();
	}

	@Override
	public void onSuspending() {
		LOGGER.info("onSuspending");
		if (actHandler != null)
			actHandler.onSuspending();
	}

	@Override
	public void onUnsuspending() {
		LOGGER.info("onUnsuspending");
		if (actHandler != null)
			actHandler.onUnsuspending();
	}

	@Override
	public void onAborting() {
		LOGGER.info("onAborting");
		if (actHandler != null)
			actHandler.onAborting();
	}

	@Override
	public void onClearing() {
		LOGGER.info("onClearing");
		if (actHandler != null)
			actHandler.onClearing();
	}

	@Override
	public void onStopping() {
		LOGGER.info("onStopping");
		if (actHandler != null)
			actHandler.onStopping();
	}
	
	/*
	 * WaitStatesHandler facade
	 */

	@Override
	public void onStopped() {
		LOGGER.info("onStopped");	
		if (waitHandler != null)
			waitHandler.onStopped();
	};

	@Override
	public void onIdle() {
		LOGGER.info("onIdle");	
		if (waitHandler != null)
			waitHandler.onIdle();
	};

	@Override
	public void onComplete() {
		LOGGER.info("onComplete");
		if (waitHandler != null)
			waitHandler.onComplete();
	};
	
	@Override
	public void onHold() {
		LOGGER.info("onHold");		
		if (waitHandler != null)
			waitHandler.onHold();
	};

	@Override
	public void onSuspend() {
		LOGGER.info("onSuspend");
		if (waitHandler != null)
			waitHandler.onSuspend();
	};

	@Override
	public void onAborted() {
		LOGGER.info("onAborted");		
		if (waitHandler != null)
			waitHandler.onAborted();
	};

}
