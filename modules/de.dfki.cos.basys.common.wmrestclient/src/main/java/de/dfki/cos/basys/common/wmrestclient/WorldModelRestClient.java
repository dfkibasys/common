package de.dfki.cos.basys.common.wmrestclient;

import java.util.List;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame;
import de.dfki.cos.basys.common.wmrestclient.dto.Hull;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition.State;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;

public interface WorldModelRestClient {

	/*
	 * Generic methods
	 */
	
	// get/setNode 		--> DataTransferObject (DTO) needed
	// get/setProperty 	--> DataTransferObject (DTO) needed
	// etc.
		
	
	/*
	 * Domain-specific methods, can reside in separate interface, e.g., HullModel
	 */
	List<Hull> getHulls();
	
	
	Hull getHull(String id);
	
	//Sector getSector(String sectorId);
	List<Frame> getFrames(String hullId, SectorEnum hullRegion);
	
	Frame getFrame(String frameId);
	Frame getFrame(String hullId, int frameIndex);
	//Frame getFrame(String hullId, SectorEnum hullRegion, int frameIndex);
	
	RivetPosition getRivetPosition(String rivetPositionId);
	RivetPosition getRivetPosition(String hullId, int frameIndex, int rivetPositionIndex);
	//RivetPosition getRivetPosition(String hullId, SectorEnum hullRegion, int frameIndex, int rivetPositionIndex);

	List<RivetPosition> getRivetPositions(String hullId, int frameIndex, int count, State state); // several frames possible
	List<RivetPosition> getRivetPositions(String hullId, SectorEnum hullRegion, int count, State state, boolean forceFrame); // several frames possible
	
	//List<RivetPosition> getRivetPositions(String hullId, SectorEnum hullRegion, int frameIndex, int count, State state); // several frames possible
		
	boolean updateRivetPosition(RivetPosition rivetPosition);	
	
}
