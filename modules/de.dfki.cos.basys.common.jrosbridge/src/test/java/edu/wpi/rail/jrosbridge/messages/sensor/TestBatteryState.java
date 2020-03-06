package edu.wpi.rail.jrosbridge.messages.sensor;

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.wpi.rail.jrosbridge.primitives.Time;

public class TestBatteryState {

	private BatteryState emptyBatteryState = new BatteryState();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		String s = emptyBatteryState.toString();

		System.out.println(s);
		System.out.println("----------");
	}

}
