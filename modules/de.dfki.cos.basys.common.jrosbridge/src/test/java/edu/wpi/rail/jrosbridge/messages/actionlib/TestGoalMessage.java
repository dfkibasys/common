package edu.wpi.rail.jrosbridge.messages.actionlib;

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.wpi.rail.jrosbridge.primitives.Time;

public class TestGoalMessage {

	private GoalID gid;
	
	@Before
	public void setUp() throws Exception {
		gid = new GoalID(new Time(10, 20), "test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		JsonObject goal = Json.createObjectBuilder().add("order", 7).build();
		GoalMessage g = new GoalMessage(gid, goal);
		String s = g.toString();
		
		System.out.println(s);
	}

}
