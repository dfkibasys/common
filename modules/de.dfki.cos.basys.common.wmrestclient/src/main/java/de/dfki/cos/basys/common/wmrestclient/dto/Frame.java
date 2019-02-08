package de.dfki.cos.basys.common.wmrestclient.dto;

import java.util.LinkedList;
import java.util.List;

import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;


public class Frame {

	public enum FrameType {
		H_9x2, V_6x2, V_10x2
	};
		
	// a UUID
	String id;
	
	// parent hull
	String parentId;
	
	// logical coordinates
	int index; 
	
	// geometrical coordinates; can we derive this information from the logical coords?
	int posX, posY;	
	
	FrameType type;
	SectorEnum hullRegion;
	
	// children	
	List<RivetPosition> rivetPositions = new LinkedList<RivetPosition>();

	public List<RivetPosition> generateChildren() {
		int n = 0;

		if (type == FrameType.H_9x2)
			n = 18;
		if (type == FrameType.V_10x2)
			n = 20;
		if (type == FrameType.V_6x2)
			n = 12;
			
		List<RivetPosition> result = new LinkedList<RivetPosition>();
		for (int i = 0; i < n; i++) {
			//RivetPosition rp = new RivetPosition(i);
			//result.add(rp);
		}
		return result;
	}
	
	
//	public Frame addRivetPosition(RivetPosition rivetPosition) {
//		rivetPositions.add(rivetPosition);
//		return this;
//	}	
	
}
