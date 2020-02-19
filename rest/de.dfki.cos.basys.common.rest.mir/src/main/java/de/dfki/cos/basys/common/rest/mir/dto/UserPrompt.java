package de.dfki.cos.basys.common.rest.mir.dto;

import java.util.List;

public class UserPrompt {
	public String guid;	
	public List<String> options;
	public String question;
	public float timeout;
	public String user_group;
}
