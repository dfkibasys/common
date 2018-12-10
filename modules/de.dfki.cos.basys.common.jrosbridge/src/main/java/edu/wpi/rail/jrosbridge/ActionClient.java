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
	
	private boolean initialized = false;
	
	protected Map<String, ActionCallback> goals = new HashMap<String, ActionCallback>();

	public ActionClient(Ros ros, String serverName, String actionName) {
		this.ros = ros;
		this.serverName = serverName;
		this.actionName = actionName;			
	}

	public boolean isInitialized() {
		return initialized;
	}
	
	public void initialize() {		
		if (!initialized) {
			feedbackListener = new Topic(ros, this.serverName + "/feedback", this.actionName + "Feedback" );
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
	
			resultListener = new Topic(ros, this.serverName + "/result", this.actionName + "Result" );
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
	
			statusListener = new Topic(ros, this.serverName + "/status", GoalStatusArray.TYPE );
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
	
			goalTopic = new Topic(ros, this.serverName + "/goal", this.actionName + "Goal" );
			goalTopic.advertise();
			
			cancelTopic = new Topic(ros, this.serverName + "/cancel", GoalID.TYPE);		
			cancelTopic.advertise();		
			
			initialized = true;
		}
	}	
	
	public void dispose() {
		goalTopic.unadvertise();
		cancelTopic.unadvertise();
		statusListener.unsubscribe();
		feedbackListener.unsubscribe();
		resultListener.unsubscribe();
	}	
	
	public Goal createGoal(ActionCallback cb) {
		Goal goal = new Goal(this);
		//TODO: remove goal when finished or canceled?
		//goals.put(goal.getId(), cb);
		goal.setActionCallback(cb);
		return goal;		
	}
	
	public Goal createGoal() {
		return createGoal(null);
	}
	
	public void cancelAll() {
		GoalID msg = new GoalID();
		cancelTopic.publish(msg);
	} 
	
	Topic getGoalTopic() {
		return goalTopic;
	}
	
	Topic getCancelTopic() {
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
