package de.dfki.iui.basys.common.scxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.iui.basys.common.scxml.unit.api.UnitImpl;
import junit.framework.TestCase;

public class TestUnit extends UnitImpl {

	enum Path {NORMAL, SUSPEND, HOLD}
	
	public Path path = Path.NORMAL;
	
	public TestUnit(String id) {
		super(id);
	}

	protected final Logger LOGGER = LoggerFactory.getLogger(TestUnit.class.getName());
	
	
	@Override
	public void updateConfig() {
		LOGGER.info("updateConfig");
		
	}
	
	@Override
	public void onResetting() {
		LOGGER.info("onResetting");
		TestCase.assertEquals(getState(), State.RESETTING);
	}

	@Override
	public void onStarting() {
		LOGGER.info("onStarting");
		TestCase.assertEquals(getState(), State.STARTING);

	}

	@Override
	public void onExecute() {
		LOGGER.info("onExecute");
		TestCase.assertEquals(getState(), State.EXECUTE);
		
		switch (path) {
		case HOLD:
			hold();
			break;
		case SUSPEND:
			suspend();
			break;
		case NORMAL:
		default:
			break;
		}
		
//		try {
//			Thread.currentThread().sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void onCompleting() {
		LOGGER.info("onCompleting");
		TestCase.assertEquals(getState(), State.COMPLETING);

	}

	@Override
	public void onHolding() {
		LOGGER.info("onHolding");
		TestCase.assertEquals(getState(), State.HOLDING);

	}

	@Override
	public void onUnholding() {
		LOGGER.info("onUnholding");
		TestCase.assertEquals(getState(), State.UNHOLDING);
		path = Path.NORMAL;

	}

	@Override
	public void onSuspending() {
		LOGGER.info("onSuspending");
		TestCase.assertEquals(getState(), State.SUSPENDING);

	}

	@Override
	public void onUnsuspending() {
		TestCase.assertEquals(getState(), State.UNSUSPENDING);
		LOGGER.info("onUnsuspending");
		path = Path.NORMAL;

	}

	@Override
	public void onAborting() {
		TestCase.assertEquals(getState(), State.ABORTING);
		LOGGER.info("onAborting");

	}

	@Override
	public void onClearing() {
		TestCase.assertEquals(getState(), State.CLEARING);
		LOGGER.info("onClearing");

	}

	@Override
	public void onStopping() {
		TestCase.assertEquals(getState(), State.STOPPING);
		LOGGER.info("onStopping");

	}

}
