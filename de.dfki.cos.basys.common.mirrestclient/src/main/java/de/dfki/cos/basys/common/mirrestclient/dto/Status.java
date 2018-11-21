package de.dfki.cos.basys.common.mirrestclient.dto;

import java.util.List;

public class Status {
	public float battery_percentage;	
	public int battery_time_remaining;	
	public float distance_to_next_target;	
	public List<Error> errors;		
	public String footprint;	
	public HookStatus hook_status;	
	public String map_id;	
	public int mission_queue_id;
	public String mission_queue_url;	
	public String mission_text;
	public int mode_id;
	public String mode_text;
	public float moved;	
	public AbsolutePosition position;
	public String robot_model;
	public String robot_name;
	public String serial_number;
	public String session_id;
	public int state_id;
	public String state_text;
	public boolean unloaded_map_changes;
	public int uptime;
	public UserPrompt user_prompt;
	public Velocity velocity;	
	public String allowed_methods;
}
