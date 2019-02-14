package de.dfki.cos.basys.common.wmrestclient.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

	FrameType type;
	SectorEnum hullRegion;
	
	// children	
	List<RivetPosition> rivetPositions = new LinkedList<RivetPosition>();

	
	
	public Frame(int index, FrameType type) {
		this(UUID.randomUUID().toString(), index, type, true);
	}
	
	public Frame(String id, int index, FrameType type, boolean generateRivetPositions) {
		this.id = id;
		this.index = index;
		this.type = type;
		if (generateRivetPositions) {
			rivetPositions = generateRivetPositions();
		}
	}

	public String getParentId() {
		return parentId;
	}
	
	public Frame setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public int getIndex() {
		return index;
	}
	
	public FrameType getType() {
		return type;
	}
	
	public List<RivetPosition> generateRivetPositions() {
		int n = 0;

		if (type == FrameType.H_9x2)
			n = 18;
		if (type == FrameType.V_10x2)
			n = 20;
		if (type == FrameType.V_6x2)
			n = 12;
			
		List<RivetPosition> result = new LinkedList<RivetPosition>();
		for (int i = 1; i <= n; i++) {
			RivetPosition rp = new RivetPosition(i)
					.setFrameIndex(getIndex())
					.setFrameType(getType())
					.setParentId(getId());
			result.add(rp);
			
		}
		return result;
	}
	
	
//	public Frame addRivetPosition(RivetPosition rivetPosition) {
//		rivetPositions.add(rivetPosition);
//		return this;
//	}	
	
}
