package de.dfki.cos.basys.common.wmrestclient.dto;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame.FrameType;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;

public class RivetPosition {
	
	public enum State {
		UNDEFINED, EMPTY, INSERTED, CHECKED_IO, CHECKED_NIO, SEALED
	}
		
	// a UUID
	String id;
		
	//parent frame
	String parentId;
	
	// logical coordinates
	int frameIndex; // global!
	FrameType frameType;
	int index;	
	
	// geometrical coordinates; can we derive this information from the logical coords?
	int posX, posY;	
	
	// current state
	State state;


	
	public State getState() {
		return state;
	}
	
	public RivetPosition setState(State state) {
		this.state = state;
		return this;
	}
	
}
