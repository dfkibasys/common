package edu.wpi.rail.jrosbridge.callback;

import javax.json.JsonObject;

import edu.wpi.rail.jrosbridge.messages.actionlib.GoalStatus;

public interface ActionCallback {

	public void handleResult(JsonObject result);
	public void handleFeedback(JsonObject feedback);
	public void handleStatus(GoalStatus status);
	
}
