package edu.wpi.rail.jrosbridge;

import java.util.Date;

import javax.json.JsonObject;

import edu.wpi.rail.jrosbridge.callback.ActionCallback;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalID;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalMessage;
import edu.wpi.rail.jrosbridge.primitives.Time;

public class Goal {

	private String id;
	private ActionClient client;
	private GoalID goalId;
	
	public Goal(ActionClient client, ActionCallback cb) {
		this.client = client;
		
		this.id = "goal_" + Math.random() + "_" + new Date().getTime();
		this.goalId = new GoalID(Time.now(), id);
		//TODO: remove goal when finished or canceled?
		client.goals.put(this.id, cb);
	}

	public void send(JsonObject goal) {
		GoalMessage goalMessage = new GoalMessage(goalId, goal);
		client.getGoalTopic().publish(goalMessage);
	}
	
	public void cancel() {
		client.getCancelTopic().publish(goalId);
	}
	


}
