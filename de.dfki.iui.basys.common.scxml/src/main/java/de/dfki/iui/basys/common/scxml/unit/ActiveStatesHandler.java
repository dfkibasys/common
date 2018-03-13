package de.dfki.iui.basys.common.scxml.unit;

public interface ActiveStatesHandler {

	void onResetting();

	void onStarting();

	void onExecute();

	void onCompleting();

	void onHolding();

	void onUnholding();

	void onSuspending();

	void onUnsuspending();

	void onAborting();

	void onClearing();

	void onStopping();

}
