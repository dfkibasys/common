package edu.wpi.rail.jrosbridge.messages.sensor;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import edu.wpi.rail.jrosbridge.messages.Message;
import edu.wpi.rail.jrosbridge.messages.std.Header;

/**
 * The sensor_msgs/BatteryState message.
 * 
 * @see http://docs.ros.org/api/sensor_msgs/html/msg/BatteryState.html
 * @author Daniel Porta -- daniel.porta@dfki.de
 * @version March 5, 2020
 */
public class BatteryState extends Message {

	/**
	 * The name of the header field for the message.
	 */
	public static final String FIELD_HEADER = "header";

	public static final String FIELD_VOLTAGE = "voltage";
	public static final String FIELD_CURRENT = "current";
	public static final String FIELD_CHARGE = "charge";
	public static final String FIELD_CAPACITY = "capacity";
	public static final String FIELD_DESIGN_CAPACITY = "design_capacity";
	public static final String FIELD_PERCENTAGE = "percentage";
	public static final String FIELD_POWER_SUPPLY_STATUS = "power_supply_status";
	public static final String FIELD_POWER_SUPPLY_HEALTH = "power_supply_health";
	public static final String FIELD_POWER_SUPPLY_TECHNOLOGY = "power_supply_technology";
	public static final String FIELD_PRESENT = "present";
	public static final String FIELD_CELL_VOLTAGE = "cell_voltage";
	public static final String FIELD_LOCATION = "location";
	public static final String FIELD_SERIAL_NUMBER = "serial_number";

	/**
	 * The message type.
	 */
	public static final String TYPE = "sensor_msgs/BatteryState";

	private final Header header;
	
	private double voltage;          // Voltage in Volts (Mandatory)
	private double current;          // Negative when discharging (A)  (If unmeasured NaN)
	private double charge;           // Current charge in Ah  (If unmeasured NaN)
	private double capacity;         // Capacity in Ah (last full capacity)  (If unmeasured NaN)
	private double design_capacity;  // Capacity in Ah (design capacity)  (If unmeasured NaN)
	private double percentage;       // Charge percentage on 0 to 1 range  (If unmeasured NaN)
	private int power_supply_status;     // The charging status as reported. Values defined above
	private int power_supply_health;     // The battery health metric. Values defined above
	private int power_supply_technology; // The battery chemistry. Values defined above
	private boolean present;         // True if the battery is present

	private double[] cell_voltage;  // An array of individual cell voltages for each cell in the pack
	                         		// If individual voltages unknown but number of cells known set each to NaN
	private String location;         // The location into which the battery is inserted. (slot number or plug)
	private String serial_number;    // The best approximation of the battery serial number
	
	

	/**
	 * Create a new BatteryState with all 0s.
	 */
	public BatteryState() {
		this(new Header(), 0.0, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, 0, 0, 0, false, new double[0], "", "");
	}

	private static JsonObject createJsonObject(Header header, double voltage, double current, double charge, double capacity, double design_capacity, double percentage, int power_supply_status, int power_supply_health, int power_supply_technology, boolean present, double[] cell_voltage, String location, String serial_number) {
		JsonObjectBuilder builder = Json.createObjectBuilder()
			.add(BatteryState.FIELD_VOLTAGE, voltage)
			.add(BatteryState.FIELD_HEADER, header.toJsonObject())
			.add(BatteryState.FIELD_POWER_SUPPLY_STATUS, power_supply_status)
			.add(BatteryState.FIELD_POWER_SUPPLY_HEALTH, power_supply_health)
			.add(BatteryState.FIELD_POWER_SUPPLY_TECHNOLOGY, power_supply_technology)
			.add(BatteryState.FIELD_PRESENT, present)
			.add(BatteryState.FIELD_CELL_VOLTAGE, Json.createArrayBuilder(Arrays.stream(cell_voltage).boxed().collect(Collectors.toList())).build())
			.add(BatteryState.FIELD_LOCATION, location)
			.add(BatteryState.FIELD_SERIAL_NUMBER, serial_number);
		
		if (!Double.isNaN(current))
			builder.add(BatteryState.FIELD_CURRENT, current);
		if (!Double.isNaN(charge))
			builder.add(BatteryState.FIELD_CHARGE, charge);		
		if (!Double.isNaN(capacity))
			builder.add(BatteryState.FIELD_CAPACITY, capacity);
		if (!Double.isNaN(design_capacity))
			builder.add(BatteryState.FIELD_DESIGN_CAPACITY, design_capacity);
		if (!Double.isNaN(percentage))
			builder.add(BatteryState.FIELD_PERCENTAGE, percentage);
		
		return builder.build();
	};
	
	/**
	 * Create a new BatteryState with the given values.
	 * 
	 * @param header
	 *            The header value of the pose.
	 */
	public BatteryState(Header header, double voltage, double current, double charge, double capacity, double design_capacity, double percentage, int power_supply_status, int power_supply_health, int power_supply_technology, boolean present, double[] cell_voltage, String location, String serial_number) {
		// build the JSON object			
		super(createJsonObject(header, voltage, current, charge, capacity, design_capacity, percentage, power_supply_status, power_supply_health, power_supply_technology, present, cell_voltage, location, serial_number),BatteryState.TYPE);
			
		this.header = header;
		this.voltage = voltage;
		this.current = current;
		this.charge = charge;
		this.capacity = capacity;
		this.design_capacity = design_capacity;
		this.percentage = percentage;
		this.power_supply_status = power_supply_status;
		this.power_supply_health = power_supply_health;
		this.power_supply_technology = power_supply_technology;
		this.present = present;
		this.cell_voltage = cell_voltage;
		this.location = location;
		this.serial_number = serial_number;
	}

	/**
	 * Get the header value of this pose.
	 * 
	 * @return The header value of this pose.
	 */
	public Header getHeader() {
		return this.header;
	}

	/**
	 * Create a clone of this PoseStamped.
	 */
	@Override
	public BatteryState clone() {
		return new BatteryState(this.header, this.voltage, this.current, this.charge, this.capacity,
				this.design_capacity, this.percentage, this.power_supply_status, this.power_supply_health,
				this.power_supply_technology, this.present, this.cell_voltage, this.location, this.serial_number);
	}

	/**
	 * Create a new BatteryState based on the given JSON string. Any missing
	 * values will be set to their defaults.
	 * 
	 * @param jsonString
	 *            The JSON string to parse.
	 * @return A BatteryState message based on the given JSON string.
	 */
	public static BatteryState fromJsonString(String jsonString) {
		// convert to a message
		return BatteryState.fromMessage(new Message(jsonString));
	}

	/**
	 * Create a new BatteryState based on the given Message. Any missing values
	 * will be set to their defaults.
	 * 
	 * @param m
	 *            The Message to parse.
	 * @return A BatteryState message based on the given Message.
	 */
	public static BatteryState fromMessage(Message m) {
		// get it from the JSON object
		return BatteryState.fromJsonObject(m.toJsonObject());
	}

	/**
	 * Create a new BatteryState based on the given JSON object. Any missing
	 * values will be set to their defaults.
	 * 
	 * @param jsonObject
	 *            The JSON object to parse.
	 * @return A BatteryState message based on the given JSON object.
	 */
	public static BatteryState fromJsonObject(JsonObject jsonObject) {
		// check the fields
		Header header = jsonObject.containsKey(BatteryState.FIELD_HEADER)
				? Header.fromJsonObject(jsonObject.getJsonObject(BatteryState.FIELD_HEADER))
				: new Header();				
		double voltage = jsonObject.containsKey(BatteryState.FIELD_VOLTAGE)
				? jsonObject.getJsonNumber(BatteryState.FIELD_VOLTAGE).doubleValue()
				: 0.0;
		double current = jsonObject.containsKey(BatteryState.FIELD_CURRENT)
				? jsonObject.getJsonNumber(BatteryState.FIELD_CURRENT).doubleValue()
				: Double.NaN;
		double charge = jsonObject.containsKey(BatteryState.FIELD_CHARGE)
				? jsonObject.getJsonNumber(BatteryState.FIELD_CHARGE).doubleValue()
				: Double.NaN;
		double capacity = jsonObject.containsKey(BatteryState.FIELD_CAPACITY)
				? jsonObject.getJsonNumber(BatteryState.FIELD_CAPACITY).doubleValue()
				: Double.NaN;
		double design_capacity = jsonObject.containsKey(BatteryState.FIELD_DESIGN_CAPACITY)
				? jsonObject.getJsonNumber(BatteryState.FIELD_DESIGN_CAPACITY).doubleValue()
				: Double.NaN;
		double percentage = jsonObject.containsKey(BatteryState.FIELD_PERCENTAGE)
				? jsonObject.getJsonNumber(BatteryState.FIELD_PERCENTAGE).doubleValue() 
				: Double.NaN;       
		int power_supply_status = jsonObject.containsKey(BatteryState.FIELD_POWER_SUPPLY_STATUS)
				? jsonObject.getJsonNumber(BatteryState.FIELD_POWER_SUPPLY_STATUS).intValue() 
				: 0;           
		int power_supply_health = jsonObject.containsKey(BatteryState.FIELD_POWER_SUPPLY_HEALTH)
				? jsonObject.getJsonNumber(BatteryState.FIELD_POWER_SUPPLY_HEALTH).intValue() 
				: 0;         
		int power_supply_technology = jsonObject.containsKey(BatteryState.FIELD_POWER_SUPPLY_TECHNOLOGY)
				? jsonObject.getJsonNumber(BatteryState.FIELD_POWER_SUPPLY_TECHNOLOGY).intValue() 
				: 0;        
		boolean present = jsonObject.containsKey(BatteryState.FIELD_PRESENT)
				? jsonObject.getBoolean(BatteryState.FIELD_PRESENT) 
				: false;            
		double[] cell_voltage = jsonObject.containsKey(BatteryState.FIELD_CELL_VOLTAGE)
				? jsonObject.getJsonArray(BatteryState.FIELD_CELL_VOLTAGE).getValuesAs(JsonNumber.class).stream()
						.mapToDouble(number -> number.doubleValue()).toArray()
				: new double[0];
		String location = jsonObject.containsKey(BatteryState.FIELD_LOCATION)
				? jsonObject.getString(BatteryState.FIELD_LOCATION) 
				: "";         
		String serial_number = jsonObject.containsKey(BatteryState.FIELD_SERIAL_NUMBER)
				? jsonObject.getString(BatteryState.FIELD_SERIAL_NUMBER) 
				: "";     										
				
		return new BatteryState(header, voltage, current, charge, capacity, design_capacity, percentage,
				power_supply_status, power_supply_health, power_supply_technology, present, cell_voltage, location,
				serial_number);
	}
}
