package de.dfki.cos.basys.common.wmrestclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dfki.cos.basys.common.wmrestclient.Queries.Queries;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.ParentFrameResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.RivetPositionBySectorResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.StateResponse;
import de.dfki.cos.basys.common.wmrestclient.SparqlClient.SparqlCommunicator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame;
import de.dfki.cos.basys.common.wmrestclient.dto.Frame.FrameType;
import de.dfki.cos.basys.common.wmrestclient.dto.Hull;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition.State;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.logging.Level;

public class WorldModelRestClientImpl implements WorldModelRestClient {

    protected final Logger LOGGER = LoggerFactory.getLogger(WorldModelRestClientImpl.class.getName());

    // private final String pathSegment = "/api/v2.0.0";
    // protected Client client = ClientBuilder.newClient();
    // protected WebTarget endpoint = null;
    String remoteRepository;
    SparqlCommunicator sparqlCommunicator;
    ObjectMapper objectMapper = new ObjectMapper();

    public WorldModelRestClientImpl(String remoteEndpointUri) {
        remoteRepository = remoteEndpointUri;
        sparqlCommunicator = new SparqlCommunicator(remoteRepository);
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

    public List<RivetPosition> getRivetPositions(String hullId, SectorEnum hullRegion) {
        try {
            String parameterizedQuery = String.format(Queries.BySector, hullRegion);
            return PerformQueryForRivetList(parameterizedQuery);
        } catch (IOException | URISyntaxException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
        String parameterizedQuery = forceFrame ?
                String.format(Queries.BySectorAndStateLimitedForceFrame, hullRegion, state, count) :
                String.format(Queries.BySectorAndStateLimited, hullRegion, state, count);

        try {
            return PerformQueryForRivetList(parameterizedQuery);
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean updateRivetPosition(RivetPosition rivetPosition) {

	StateResponse state = GetStateForRivet(rivetPosition.getId());
	Client client = ClientBuilder.newClient();
	WebTarget endpoint = client.target(state.stateUri);
	Response response = endpoint
		.request(MediaType.APPLICATION_JSON_TYPE)
		.post(Entity.json(String.format("\"%d\"", rivetPosition.getState().ordinal())));
	return response.getStatus() == 204;
    }

    private List<RivetPosition> PerformQueryForRivetList(String parameterizedQuery) throws URISyntaxException, IOException {
        List<RivetPosition> results = new LinkedList<>();
        String responseString = sparqlCommunicator.performQuery(parameterizedQuery);
        RivetPositionBySectorResponse[] receivedObjects
                = objectMapper.readValue(responseString, RivetPositionBySectorResponse[].class);
        for (RivetPositionBySectorResponse r : receivedObjects) {
            RivetPosition receivedRivet = new RivetPosition(r.id, r.rivetUri, r.index);
            GetRivetPositionData(receivedRivet);
            results.add(receivedRivet);
        }

        return results;
    }

    private RivetPosition GetRivetPositionData(RivetPosition rivetPosition) {
        Frame parentFrame = GetFrameForRivet(rivetPosition.getResourceUri());
        rivetPosition.setFrameIndex(parentFrame.getIndex());
        rivetPosition.setParentId(parentFrame.getId());
        rivetPosition.setFrameType(parentFrame.getType());

        StateResponse state = GetStateForRivet(rivetPosition.getId());
        rivetPosition.setStateAttributeUri(state.stateUri);
        rivetPosition.setState(state.state);
        return rivetPosition;
    }

    private Frame GetFrameForRivet(String rivetUri) {
        Frame result = new Frame(0, FrameType.H_9x2);
        String parameterizedQuery = String.format(Queries.RivetPositionParentFrame, rivetUri);
        try {
            String resultString = sparqlCommunicator.performQuery(parameterizedQuery);
            ParentFrameResponse[] receivedObjects
                    = objectMapper.readValue(resultString, ParentFrameResponse[].class);
            ParentFrameResponse firstObject = receivedObjects[0];
            return new Frame(firstObject.id, firstObject.index, firstObject.type, false);
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private StateResponse GetStateForRivet(String rivetID) {
        String parameterizedQuery = String.format(Queries.RivetPositionState, rivetID);
        try {
            String resultString = sparqlCommunicator.performQuery(parameterizedQuery);
            StateResponse[] receivedObjects;
            receivedObjects = objectMapper.readValue(resultString, StateResponse[].class);
            return receivedObjects[0];
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
