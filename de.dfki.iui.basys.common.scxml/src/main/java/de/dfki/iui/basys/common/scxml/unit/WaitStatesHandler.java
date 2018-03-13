package de.dfki.iui.basys.common.scxml.unit;

public interface WaitStatesHandler {

	void onStopped();

	void onIdle();

	void onComplete();

	void onHold();

	void onSuspend();

	void onAborted();

}
