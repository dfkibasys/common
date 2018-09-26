package edu.wpi.rail.jrosbridge;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.json.JsonObject;

import edu.wpi.rail.jrosbridge.callback.ActionCallback;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalID;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalMessage;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalStatus;
import edu.wpi.rail.jrosbridge.primitives.Time;

public class Goal implements ActionCallback {

	private String id;
	private ActionClient client;
	private GoalID goalId;
	private ActionCallback cb;
	
	private GoalStatusEnum status;
	private List<JsonObject> feedback = new LinkedList<JsonObject>();
	private JsonObject result;
	
	Goal(ActionClient client) {
		this.client = client;
		
		this.id = "goal_" + Math.random() + "_" + new Date().getTime();
		this.goalId = new GoalID(Time.now(), id);		
	}
	
	public String getId() {
		return id;
	}

	public void submit(JsonObject goal) {
		client.initialize();
		
		client.goals.put(getId(), this);
		
		GoalMessage goalMessage = new GoalMessage(goalId, goal);
		client.getGoalTopic().publish(goalMessage);
	}

	public void cancel() {
		client.initialize();
		
		client.getCancelTopic().publish(goalId);
	}
	
	public void setActionCallback(ActionCallback cb) {
		this.cb = cb;
	}
	
	public GoalStatusEnum getStatus() {
		return status;
	}
	
	public List<JsonObject> getFeedback() {
		return feedback;
	}
	
	public JsonObject getResult() {
		return result;
	}
	
	
	@Override
	public void handleStatus(GoalStatus status) {
		this.status = GoalStatusEnum.values()[status.getStatus()];	
		if (cb != null) {
			cb.handleStatus(status);
		}
	}
	
	@Override
	public void handleResult(JsonObject result) {
		this.result = result;
		if (cb != null) {
			cb.handleResult(result);			
		}
	}
	
	@Override
	public void handleFeedback(JsonObject feedback) {
		this.feedback.add(feedback);
		if (cb != null) {
			cb.handleFeedback(feedback);
		}
	}
	
	public enum GoalStatusEnum {
		
		/**
		 * The goal has yet to be processed by the action server.
		 */
		PENDING(GoalStatus.PENDING),

		/**
		 * The goal is currently being processed by the action server.
		 */
		 ACTIVE(GoalStatus.ACTIVE),

		/**
		 * The goal received a cancel request after it started executing and has
		 * since completed its execution (Terminal State).
		 */
		PREEMPTED(GoalStatus.PREEMPTED),

		/**
		 * The goal was achieved successfully by the action server (Terminal State).
		 */
		SUCCEEDED(GoalStatus.SUCCEEDED),

		/**
		 * The goal was aborted during execution by the action server due to some
		 * failure (Terminal State).
		 */
		ABORTED(GoalStatus.ABORTED),

		/**
		 * The goal was rejected by the action server without being processed,
		 * because the goal was unattainable or invalid (Terminal State).
		 */
		REJECTED(GoalStatus.REJECTED),

		/**
		 * The goal received a cancel request after it started executing and has not
		 * yet completed execution.
		 */
		PREEMPTING(GoalStatus.PREEMPTING),

		/**
		 * The goal received a cancel request before it started executing, but the
		 * action server has not yet confirmed that the goal is canceled.
		 */
		RECALLING(GoalStatus.RECALLING),

		/**
		 * The goal received a cancel request before it started executing and was
		 * successfully cancelled (Terminal State).
		 */
		RECALLED(GoalStatus.RECALLED),

		/**
		 * An action client can determine that a goal is LOST. This should not be
		 * sent over the wire by an action server.
		 */
		LOST(GoalStatus.LOST);
		
		private byte value;
		
		public byte getValue() {
			return value;
		}
		
		private GoalStatusEnum(byte value) {
			this.value = value;
		}		
	}

}

