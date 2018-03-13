package de.dfki.iui.basys.common.scxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.iui.basys.common.scxml.unit.ActiveStatesHandler;
import de.dfki.iui.basys.common.scxml.unit.PackMLUnit;
import de.dfki.iui.basys.common.scxml.unit.State;
import junit.framework.TestCase;

public class TestHandler implements ActiveStatesHandler {

	protected final Logger LOGGER = LoggerFactory.getLogger(TestHandler.class.getName());
		
	enum Path {NORMAL, SUSPEND, HOLD}
	
	public Path path = Path.NORMAL;
	
	PackMLUnit unit;
	
	public TestHandler(PackMLUnit unit) {
		this.unit = unit;
	}

	public void initialize() {
		unit.initialize();
	}

	public void dispose() {
		unit.dispose();
	}
	
	@Override
	public void onResetting() {
		LOGGER.info("onResetting");
		TestCase.assertEquals(unit.getState(), State.RESETTING);
	}

	@Override
	public void onStarting() {
		LOGGER.info("onStarting");
		TestCase.assertEquals(unit.getState(), State.STARTING);

	}

	@Override
	public void onExecute() {
		LOGGER.info("onExecute");
		TestCase.assertEquals(unit.getState(), State.EXECUTE);
		
		switch (path) {
		case HOLD:
			unit.hold();
			break;
		case SUSPEND:
			unit.suspend();
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
		TestCase.assertEquals(unit.getState(), State.COMPLETING);

	}

	@Override
	public void onHolding() {
		LOGGER.info("onHolding");
		TestCase.assertEquals(unit.getState(), State.HOLDING);

	}

	@Override
	public void onUnholding() {
		LOGGER.info("onUnholding");
		TestCase.assertEquals(unit.getState(), State.UNHOLDING);
		path = Path.NORMAL;

	}

	@Override
	public void onSuspending() {
		LOGGER.info("onSuspending");
		TestCase.assertEquals(unit.getState(), State.SUSPENDING);

	}

	@Override
	public void onUnsuspending() {
		TestCase.assertEquals(unit.getState(), State.UNSUSPENDING);
		LOGGER.info("onUnsuspending");
		path = Path.NORMAL;

	}

	@Override
	public void onAborting() {
		TestCase.assertEquals(unit.getState(), State.ABORTING);
		LOGGER.info("onAborting");

	}

	@Override
	public void onClearing() {
		TestCase.assertEquals(unit.getState(), State.CLEARING);
		LOGGER.info("onClearing");

	}

	@Override
	public void onStopping() {
		TestCase.assertEquals(unit.getState(), State.STOPPING);
		LOGGER.info("onStopping");

	}

}
