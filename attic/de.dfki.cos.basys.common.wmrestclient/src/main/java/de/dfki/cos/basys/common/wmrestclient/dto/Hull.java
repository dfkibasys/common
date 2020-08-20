package de.dfki.cos.basys.common.wmrestclient.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hull implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// a UUID
	String id;

	// children
	List<Frame> frames = new LinkedList<Frame>();
	
	public Hull() {
		this(UUID.randomUUID().toString());
	}
	
	public Hull(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
	
	public Hull addFrame(Frame frame) {
		frames.add(frame.setParentId(getId()));		
		return this;
	}
	
//	public Hull addSector(Sector sector) {
//		this.sectors.add(sector);
//		return this;
//	}
	
}
