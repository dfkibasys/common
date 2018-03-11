package de.dfki.iui.basys.common.scxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import junit.framework.TestCase;
import de.dfki.iui.basys.common.scxml.TestUnit.Path;
import de.dfki.iui.basys.common.scxml.unit.api.Unit.State;

public class PackMLTests extends TestCase {

	protected final Logger LOGGER = LoggerFactory.getLogger(PackMLTests.class.getName());
	
	TestUnit unit;
	
	protected void setUp() throws Exception {		
		super.setUp();
		LOGGER.info("setUp");
		
		unit = new TestUnit("test_unit");
		unit.initialize();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		LOGGER.info("tearDown");
		
		unit.dispose();
	}

	public void testExecute() {
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
		unit.start();
		assertEquals(State.COMPLETE, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
	}
	
	public void testHold() {
		unit.path = Path.HOLD;
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
		unit.start();
		assertEquals(State.HELD, unit.getState());
		unit.unhold();
		assertEquals(State.COMPLETE, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
	}
	
	public void testSuspend() {
		unit.path = Path.SUSPEND;
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
		unit.start();
		assertEquals(State.SUSPENDED, unit.getState());
		unit.unsuspend();
		assertEquals(State.COMPLETE, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
	}
	
	public void testStop() {
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
		unit.start();
		assertEquals(State.COMPLETE, unit.getState());
		unit.stop();
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
	}
	
	public void testAbort() {
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
		unit.start();
		assertEquals(State.COMPLETE, unit.getState());
		unit.abort();
		assertEquals(State.ABORTED, unit.getState());
		unit.clear();
		assertEquals(State.STOPPED, unit.getState());
		unit.reset();
		assertEquals(State.IDLE, unit.getState());
	}
	
}
