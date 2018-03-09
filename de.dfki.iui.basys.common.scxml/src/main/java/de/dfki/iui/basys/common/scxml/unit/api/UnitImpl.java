package de.dfki.iui.basys.common.scxml.unit.api;


public abstract class UnitImpl implements Unit {

	private String id;

	boolean initialized = false;

	PackML packml = null;
	
	UnitConfiguration config;

	///////////////////////////////

	public void BaseUnit(String id) {
		this.id = id;
		packml = new PackML(this);
	}

	protected void initialize() {
		packml.initialize();
	}

	protected void dispose() {
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
		packml.raiseLifecycleEvent("reset");
	}

	@Override
	public void start() {
		packml.raiseLifecycleEvent("start");
	}

	@Override
	public void stop() {
		packml.raiseLifecycleEvent("stop");
	}

	@Override
	public void hold() {
		packml.raiseLifecycleEvent("hold");
	}

	@Override
	public void unhold() {
		packml.raiseLifecycleEvent("unhold");
	}

	@Override
	public void suspend() {
		packml.raiseLifecycleEvent("suspend");
	}

	@Override
	public void unsuspend() {
		packml.raiseLifecycleEvent("unsuspend");
	}

	@Override
	public void abort() {
		packml.raiseLifecycleEvent("abort");
	}

	@Override
	public void clear() {
		packml.raiseLifecycleEvent("clear");
	}


}
