package de.dfki.cos.basys.common.wmrestclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame;
import de.dfki.cos.basys.common.wmrestclient.dto.Hull;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition.State;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;

public class WorldModelRestClientImpl implements WorldModelRestClient {

	protected final Logger LOGGER = LoggerFactory.getLogger(WorldModelRestClientImpl.class.getName());

	private final String pathSegment = "/api/v2.0.0";
	
	protected Client client = ClientBuilder.newClient();
	protected WebTarget endpoint = null;

	
	public WorldModelRestClientImpl(String host) {
		this.endpoint = client.target(host).path(pathSegment);
	}

	@Override
	public Hull getHull(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Frame> getFrames(String hullId, SectorEnum hullRegion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame getFrame(String frameId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frame getFrame(String hullId, int frameIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RivetPosition getRivetPosition(String rivetPositionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RivetPosition getRivetPosition(String hullId, int frameIndex, int rivetPositionIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RivetPosition> getRivetPositions(String hullId, int frameIndex, int count, State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RivetPosition> getRivetPositions(String hullId, SectorEnum hullRegion, int count, State state,
			boolean forceFrame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRivetPosition(RivetPosition rivetPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
