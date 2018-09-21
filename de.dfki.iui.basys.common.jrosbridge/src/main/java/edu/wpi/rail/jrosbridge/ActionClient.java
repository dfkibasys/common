package edu.wpi.rail.jrosbridge;

import java.util.HashMap;
import java.util.Map;

import javax.json.JsonArray;
import javax.json.JsonObject;

import edu.wpi.rail.jrosbridge.callback.ActionCallback;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalID;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalStatus;
import edu.wpi.rail.jrosbridge.messages.actionlib.GoalStatusArray;

public class ActionClient {

	private final Ros ros;
	private final String serverName;
	private final String actionName;

	private Topic feedbackListener;
	private Topic statusListener;
	private Topic resultListener;
	private Topic goalTopic;
	private Topic cancelTopic;
	
	protected Map<String, ActionCallback> goals = new HashMap<String, ActionCallback>();

	public ActionClient(Ros ros, String serverName, String actionName) {
		this.ros = ros;
		this.serverName = serverName;
		this.actionName = actionName;

		feedbackListener = new Topic(ros, this.serverName + "/feedback", this.actionName + "Feedback" );
		statusListener = new Topic(ros, this.serverName + "/status", GoalStatusArray.TYPE );
		resultListener = new Topic(ros, this.serverName + "/result", this.actionName + "Result" );

		goalTopic = new Topic(ros, this.serverName + "/goal", this.actionName + "Goal" );
		cancelTopic = new Topic(ros, this.serverName + "/cancel", GoalID.TYPE);
			
	}

	public void initialize() {
		goalTopic.advertise();
		cancelTopic.advertise();
		
		feedbackListener.subscribe(new TopicCallback() {
			
			@Override
			public void handleMessage(Message message) {
				String goalId = message.toJsonObject().getJsonObject("status").getJsonObject("goal_id").getString("id");
				if (goals.containsKey(goalId)) {
					ActionCallback cb = goals.get(goalId);
					cb.handleStatus(GoalStatus.fromJsonObject(message.toJsonObject().getJsonObject("status")));
					cb.handleFeedback(message.toJsonObject().getJsonObject("feedback"));
				}
			}
		});

		resultListener.subscribe(new TopicCallback() {
			
			@Override
			public void handleMessage(Message message) {
				String goalId = message.toJsonObject().getJsonObject("status").getJsonObject("goal_id").getString("id");
				if (goals.containsKey(goalId)) {
					ActionCallback cb = goals.get(goalId);
					cb.handleStatus(GoalStatus.fromJsonObject(message.toJsonObject().getJsonObject("status")));
					cb.handleResult(message.toJsonObject().getJsonObject("result"));
				}
			}
		});
		
		statusListener.subscribe(new TopicCallback() {
			
			@Override
			public void handleMessage(Message message) {
				JsonArray statusList = message.toJsonObject().getJsonArray("status_list");
				statusList.forEach(status -> {
					String goalId = ((JsonObject)status).getJsonObject("goal_id").getString("id");
					if (goals.containsKey(goalId)) {
						ActionCallback cb = goals.get(goalId);
						cb.handleStatus(GoalStatus.fromJsonObject((JsonObject)status));
					}
				});				
			}
		});
		
	}	
	
	public void dispose() {
		goalTopic.unadvertise();
		cancelTopic.unadvertise();
	}
	
	public void cancel() {
		GoalID msg = new GoalID();
		cancelTopic.publish(msg);
	} 
	
	public Topic getGoalTopic() {
		return goalTopic;
	}
	
	public Topic getCancelTopic() {
		return cancelTopic;
	}
	
	/**
	 * Get the ROS connection handle for this service.
	 * 
	 * @return The ROS connection handle for this service.
	 */
	public Ros getRos() {
		return this.ros;
	}


	public String getServerName() {
		return this.serverName;
	}

	public String getActionName() {
		return actionName;
	}


}
