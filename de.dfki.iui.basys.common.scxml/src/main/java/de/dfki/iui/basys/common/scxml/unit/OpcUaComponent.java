package de.dfki.iui.basys.common.scxml.unit;

public class OpcUaComponent extends AbstractComponent {

	public OpcUaComponent(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	// TODO: Code for communicating with the actual device, here via OPC-UA.
	// Could also be done in some kind of "IntegrationProvider" implementation.

	/*
	 * default ActiveStatesHandler implementation -> trigger logic on device
	 */

	@Override
	public void onResetting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStarting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCompleting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHolding() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnholding() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSuspending() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnsuspending() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAborting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClearing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopping() {
		// TODO Auto-generated method stub

	}

}
