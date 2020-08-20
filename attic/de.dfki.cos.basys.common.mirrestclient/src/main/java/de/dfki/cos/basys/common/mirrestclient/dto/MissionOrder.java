package de.dfki.cos.basys.common.mirrestclient.dto;

import java.util.LinkedList;
import java.util.List;

public class MissionOrder {
	public String mission_id;
	public String message;
	public List<Parameter> parameters = new LinkedList<Parameter>();
	public int priority;
	
	public MissionOrder(String mission_id, String message) {
		super();
		this.mission_id = mission_id;
		this.message = message;
	}
	
}
