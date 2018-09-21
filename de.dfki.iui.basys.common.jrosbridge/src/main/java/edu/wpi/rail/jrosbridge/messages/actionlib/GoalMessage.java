package edu.wpi.rail.jrosbridge.messages.actionlib;

import javax.json.Json;
import javax.json.JsonObject;

import edu.wpi.rail.jrosbridge.messages.Message;
import edu.wpi.rail.jrosbridge.messages.std.Header;

/**
 * The actionlib_msgs/GoalID message. The stamp should store the time at which
 * this goal was requested. It is used by an action server when it tries to
 * preempt all goals that were requested before a certain time
 * 
 * The id provides a way to associate feedback and result message with specific
 * goal requests. The id specified must be unique.
 * 
 * @author Russell Toris -- russell.toris@gmail.com
 * @version April 1, 2014
 */
public class GoalMessage extends Message {

	/**
	 * The name of the header field for the message.
	 */
	public static final String FIELD_HEADER = "header";

	/**
	 * The name of the ID field for the message.
	 */
	public static final String FIELD_ID = "goal_id";
	
	/**
	 * The name of the goal field for the message.
	 */
	public static final String FIELD_GOAL = "goal";


	private final Header header;
	private final GoalID id;
	private final JsonObject goal;


	public GoalMessage(GoalID id, JsonObject goal) {
		this(new Header(), id, goal);
	}
	
	public GoalMessage(Header header, GoalID id, JsonObject goal) {
		// build the JSON object
		super(Json.createObjectBuilder()
				.add(GoalMessage.FIELD_HEADER, header.toJsonObject())
				.add(GoalMessage.FIELD_ID, id.toJsonObject())
				.add(GoalMessage.FIELD_GOAL, goal).build());
		
		this.header = header;
		this.id = id;
		this.goal = goal;
	}

	public Header getHeader() {
		return header;
	}
	
	public GoalID getId() {
		return id;
	}
	
	public JsonObject getGoal() {
		return goal;
	}

	/**
	 * Create a clone of this Goal.
	 */
	@Override
	public GoalMessage clone() {
		return new GoalMessage(this.header, this.id, this.goal);
	}

	/**
	 * Create a new Goal based on the given JSON string. Any missing values
	 * will be set to their defaults.
	 * 
	 * @param jsonString
	 *            The JSON string to parse.
	 * @return A Goal message based on the given JSON string.
	 */
	public static GoalMessage fromJsonString(String jsonString) {
		// convert to a message
		return GoalMessage.fromMessage(new Message(jsonString));
	}

	/**
	 * Create a new Goal based on the given Message. Any missing values will
	 * be set to their defaults.
	 * 
	 * @param m
	 *            The Message to parse.
	 * @return A Goal message based on the given Message.
	 */
	public static GoalMessage fromMessage(Message m) {
		// get it from the JSON object
		return GoalMessage.fromJsonObject(m.toJsonObject());
	}

	/**
	 * Create a new Goal based on the given JSON object. Any missing values
	 * will be set to their defaults.
	 * 
	 * @param jsonObject
	 *            The JSON object to parse.
	 * @return A Goal message based on the given JSON object.
	 */
	public static GoalMessage fromJsonObject(JsonObject jsonObject) {

		Header header = jsonObject.containsKey(GoalMessage.FIELD_HEADER) ? Header.fromJsonObject(jsonObject.getJsonObject(GoalMessage.FIELD_HEADER)) : new Header();
		GoalID id = jsonObject.containsKey(GoalMessage.FIELD_ID) ? GoalID.fromJsonObject(jsonObject.getJsonObject(GoalMessage.FIELD_ID)) : new GoalID();
		JsonObject goal =  jsonObject.containsKey(GoalMessage.FIELD_GOAL) ? jsonObject.getJsonObject(GoalMessage.FIELD_GOAL) : JsonObject.EMPTY_JSON_OBJECT;
		
		return new GoalMessage(header, id, goal);
	}
}
