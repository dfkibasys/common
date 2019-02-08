package de.dfki.cos.basys.common.wmrestclient.dto;

import java.util.LinkedList;
import java.util.List;

public class Hull {
	
	// a UUID
	String id;

	// children
	List<Frame> frames = new LinkedList<Frame>();
	

//	public Hull addSector(Sector sector) {
//		this.sectors.add(sector);
//		return this;
//	}
	
}
