package de.dfki.iui.basys.common.scxml.unit.api;

import java.util.Map;

/**
 * Represents a manufacturing unit which can be implemented by real machines
 *
 * @author Philipp
 *
 */
public interface Unit extends ActiveStatesHandler {

	public enum State {
		IDLE,
		STARTING,
		EXECUTE,
		COMPLETING,
		COMPLETE,
		RESETTING,
		HOLDING,
		HELD,
		UNHOLDING,
		SUSPENDING,
		SUSPENDED,
		UNSUSPENDING,
		STOPPING,
		STOPPED,
		ABORTING,
		ABORTED,
		CLEARING
	}

	public enum Mode {
		PRODUCTION,
		MAINTENANCE,
		MANUAL,
		CHANGE_OVER,
		CLEAN,
		SET_UP,
		EMPTY_OUT		
	}

	/**
	 * Return the unique identifier of this {@link Unit}.
	 *
	 * @return the unique identifier
	 */
	String getId();

	/**
	 * Returns the lifecycle state the {@link Unit} is currently in.
	 *
	 * @return the unit state
	 */
	State getState();
	
	/**
	 * Returns the mode the {@link Unit} is currently in.
	 *
	 * @return the unit mode
	 */
	Mode getMode();
	
	void changeMode(Mode mode);
	
	void reset();
	void start();
	void stop();
	void hold();
	void unhold();
	void suspend();
	void unsuspend();
	void abort();
	void clear();

	UnitConfiguration getConfig();
	void setConfig(UnitConfiguration config);

	void onStopped();
	void onIdle();
	void onComplete();
	void onHold();
	void onSuspend();
	void onAborted();

}
