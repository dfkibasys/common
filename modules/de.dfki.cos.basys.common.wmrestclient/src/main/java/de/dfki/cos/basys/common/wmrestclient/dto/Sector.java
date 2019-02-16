package de.dfki.cos.basys.common.wmrestclient.dto;

import java.util.List;

public class Sector {

	public enum SectorEnum {
		UNDEFINED, TOP_LEFT, TOP_CENTER, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_CENTER, BOTTOM_LEFT, LEFT, CENTER, RIGHT
	}
	
	// a UUID
	String id;

	//parent
	String parentId;
	
	// logical Coordinates	
	SectorEnum hullRegion;
	
	// geometrical Coordinates; can we derive this information from the logical coords?
	int posX, posY;
	
	// children
	List<Frame> frames;
	
	
//	public Sector addFrame(Frame frame) {
//		this.frames.add(frame);
//		return this;
//	}
}
