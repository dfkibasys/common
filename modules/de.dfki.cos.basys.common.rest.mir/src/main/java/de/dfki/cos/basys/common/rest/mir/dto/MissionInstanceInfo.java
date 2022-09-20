package de.dfki.cos.basys.common.rest.mir.dto;

import java.util.Date;
import java.util.List;

public class MissionInstanceInfo {
	public String actions;
	public String[] allowed_methods;
	public String control_posid;
	public int control_state;
	public String created_by;
	public String created_by_id;
	public String created_by_name;
	public String description;
	public Date finished; // Date
	public String fleet_schedule_guid;
	public int id;
	public String message;
	public String mission;
	public String mission_id;
	public Date ordered; // Date when the mission was queued string (date-time)
	public List<Parameter> parameters;
	public int priority;
	public Date started; // Date and time when the mission was started string (date-time)
	public String state;
	
	public MissionInstance toMissionInstance() {
		MissionInstance instance = new MissionInstance();
		instance.id = id;
		instance.state = state;
		instance.url = "";
		return instance;
	}
}
