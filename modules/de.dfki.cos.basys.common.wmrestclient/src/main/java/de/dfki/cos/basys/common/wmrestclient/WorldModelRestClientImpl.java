package de.dfki.cos.basys.common.wmrestclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dfki.cos.basys.common.wmrestclient.Queries.Queries;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.HullsResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.FrameResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.FrameUriResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.HullDataResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.NumRivetsResponse;
import de.dfki.cos.basys.common.wmrestclient.QueryResponses.RivetPositionResponse;
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
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public List<Hull> getHulls() {
        try {
            String hullsResponse = sparqlCommunicator.performQuery(Queries.getHulls);
            HullsResponse[] responseObjects = objectMapper.readValue(hullsResponse, HullsResponse[].class);
            List<Hull> result = new LinkedList<>();
            for (HullsResponse r : responseObjects) {
                result.add(new Hull(r.hullId));
            }
            return result;
        } catch (IOException | URISyntaxException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Hull getHull(String id) {
        try {
            String paratemerizedQuery = String.format(Queries.HullQueries.GetAllRivetPositions, id);
            String responseString = sparqlCommunicator.performQuery(paratemerizedQuery);
            Hull hull = new Hull(id);
            HullDataResponse[] receivedObjects = objectMapper.readValue(responseString, HullDataResponse[].class);
            BuildFrames(receivedObjects, hull);
            return hull;
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Frame> getFrames(String hullId, SectorEnum hullRegion) {
        try {
            String parameterizedQuery = String.format(Queries.FramesInHull,
                    hullId,
                    "",
                    String.format("rdf:value '%s'^^<xsd:attributeValue> ;", hullRegion));
            return performQueryForFramesList(parameterizedQuery);
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Frame getFrame(String frameId) {
        String parameterizedQuery = String.format(Queries.SingleFrameById, frameId);
        try {
            List<Frame> frameResults = performQueryForFramesList(parameterizedQuery);
            // The query parameters will match one exact frame, or none. In case we have a result,
            // the only and first one in the list is the one that was queried
            if (!frameResults.isEmpty()) {
                return frameResults.get(0);
            }
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Frame getFrame(String hullId, int frameIndex) {
        String parameterizedQuery = String.format(Queries.FramesInHull,
                hullId,
                String.format("rdf:value '%d'^^<xsd:attributeValue> ;", frameIndex),
                "");
        try {
            List<Frame> frameResults = performQueryForFramesList(parameterizedQuery);
            // The query parameters will match one exact frame, or none. In case we have a result,
            // the only and first one in the list is the one that was queried
            if (!frameResults.isEmpty()) {
                return frameResults.get(0);
            }
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RivetPosition getRivetPosition(String rivetPositionId) {
        String parameterizedQuery = String.format(Queries.SinlgeRivetPositionById, rivetPositionId);
        try {
            List<RivetPosition> rivetResults = PerformQueryForRivetList(parameterizedQuery);
            // The query parameters will match one exact rivet, or none. In case we have a result,
            // the only and first one in the list is the one that was queried
            if (!rivetResults.isEmpty()) {
                return rivetResults.get(0);
            }
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RivetPosition getRivetPosition(String hullId, int frameIndex, int rivetPositionIndex) {
        try {
            String parameterizedQuery = String.format(Queries.SingleRivetByFrameAndRivetIndex, hullId, frameIndex, rivetPositionIndex);
            List<RivetPosition> rivetResults = PerformQueryForRivetList(parameterizedQuery);
            // The query parameters will match one exact rivet, or none. In case we have a result,
            // the only and first one in the list is the one that was queried
            if (!rivetResults.isEmpty()) {
                return rivetResults.get(0);
            }

        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<RivetPosition> getRivetPositions(String hullId, int frameIndex, int count, State state) {
        try {
            String parameterizedQuery = String.format(Queries.ByParentFrameIndexAndState, hullId, frameIndex, state, count);
            return PerformQueryForRivetList(parameterizedQuery);
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean updateRivetPosition(RivetPosition rivetPosition) {
        LOGGER.debug("updateRivetPosition({})", rivetPosition.toString());
        String hullID = getHulls().get(0).getId();
        StateResponse state = GetStateForRivet(rivetPosition.getFrameIndex(), rivetPosition.getIndex());
        Client client = ClientBuilder.newClient();
        WebTarget endpoint = client.target(state.stateUri);
        Response response = endpoint
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(String.format("\"%s\"", rivetPosition.getState())));
        return response.getStatus() == 204;
    }

    @Override
    public List<RivetPosition> getRivetPositions(String hullId, SectorEnum hullRegion, int maxCount, State state,
            boolean forceFrame) {

        try {
            List<RivetPosition> returnedRivets = new LinkedList<>();
            if (forceFrame) {
                returnedRivets = GetRivetsInSingleFrameByStatus(hullId, hullRegion, state, maxCount);
            } else {
                String parameterizedQuery = String.format(Queries.BySectorAndState, hullId, hullRegion, state, maxCount);

                returnedRivets = PerformQueryForRivetList(parameterizedQuery);
                returnedRivets.stream().sorted((RivetPosition r1, RivetPosition r2) -> r1.getIndex() - r2.getIndex());
            }
            return returnedRivets;
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void BuildFrames(HullDataResponse[] hullData, Hull hull) {
        for (HullDataResponse data : hullData) {
            Frame frameForRivet = new Frame(data.frameId, data.frameIndex, data.frameType, data.hullRegion, false);
            frameForRivet.setParentId(hull.getId());
            if (hull.getFrames().stream().filter(f -> f.getId().equals(data.frameId)).findFirst().isPresent()) {
                frameForRivet = hull.getFrames().stream().filter(f -> f.getId().equals(data.frameId)).findFirst().get();
            } else {
                hull.addFrame(frameForRivet);
            }
            AddRivetToFrame(frameForRivet, data);
        }
    }

    private void AddRivetToFrame(Frame frame, HullDataResponse data) {
        RivetPosition r = new RivetPosition(data.rivetId, data.rivetUri, data.index);
        r.setFrameIndex(data.frameIndex);
        r.setFrameType(data.frameType);
        r.setParentId(data.frameId);
        r.setState(data.status);
        r.setStateAttributeUri(data.statusUri);
        frame.AddRivetPosition(r);
    }

    private List<Frame> performQueryForFramesList(String parameterizedQuery) throws URISyntaxException, IOException {
        String framesResponse = sparqlCommunicator.performQuery(parameterizedQuery);
        FrameResponse[] responseObjects = objectMapper.readValue(framesResponse, FrameResponse[].class);
        List<Frame> resultList = new LinkedList<>();
        for (FrameResponse r : responseObjects) {
            Frame frame = new Frame(r.id, r.index, r.type, r.hullregion, false);
            getRivetsForFrame(frame);
            frame.setParentId(r.hullId);
            resultList.add(frame);
        }
        return resultList;
    }

    private Frame getRivetsForFrame(Frame frame) throws URISyntaxException, IOException {
        String parameterizedQuery = String.format(Queries.RivetPositionsInFrame, frame.getId());
        List<RivetPosition> rivets = PerformQueryForRivetList(parameterizedQuery);
        frame.AddRivetPositions(rivets);
        return frame;
    }

    private List<RivetPosition> GetRivetsInSingleFrameByStatus(String hullId, SectorEnum sector, State state, int maxCount) throws IOException, URISyntaxException {
        String parameterizedQuery = String.format(Queries.FrameUriInSector, sector);
        String responseString = sparqlCommunicator.performQuery(parameterizedQuery);
        FrameUriResponse[] receivedObjects = objectMapper.readValue(responseString, FrameUriResponse[].class);
        for (FrameUriResponse frame : receivedObjects) {
            if (GetCountOfRivetsWithState(frame.frameUri, state) > 0) {
                return getRivetPositions(hullId, frame.frameIndex, maxCount, state);
            }
        }
        return new LinkedList<>();
    }

    private int GetCountOfRivetsWithState(String frameUri, State state) throws IOException, URISyntaxException {
        String parameterizedQuery = String.format(Queries.CountRivetsWithStateInFrame, frameUri, state);
        String responseString = sparqlCommunicator.performQuery(parameterizedQuery);
        NumRivetsResponse[] receivedObjects = objectMapper.readValue(responseString, NumRivetsResponse[].class);
        if (receivedObjects.length > 0) {
            return receivedObjects[0].numRivets;
        }
        return 0;
    }

    private List<RivetPosition> PerformQueryForRivetList(String parameterizedQuery) throws URISyntaxException, IOException {
        List<RivetPosition> results = new LinkedList<>();
        String responseString = sparqlCommunicator.performQuery(parameterizedQuery);
        RivetPositionResponse[] receivedObjects
                = objectMapper.readValue(responseString, RivetPositionResponse[].class);
        for (RivetPositionResponse r : receivedObjects) {
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
            FrameResponse[] receivedObjects
                    = objectMapper.readValue(resultString, FrameResponse[].class);
            FrameResponse firstObject = receivedObjects[0];
            return new Frame(firstObject.id, firstObject.index, firstObject.type, false);
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private StateResponse GetStateForRivet(int frameIndex, int rivetIndex) {
        String parameterizedQuery = String.format(Queries.RivetStatusByIndices, frameIndex, rivetIndex);
        try {
            return performQueryForRivetState(parameterizedQuery);
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private StateResponse GetStateForRivet(String rivetID) {
        String parameterizedQuery = String.format(Queries.RivetPositionState, rivetID);
        try {
            return performQueryForRivetState(parameterizedQuery);
        } catch (URISyntaxException | IOException ex) {
            java.util.logging.Logger.getLogger(WorldModelRestClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private StateResponse performQueryForRivetState(String parameterizedQuery) throws URISyntaxException, IOException {
        String resultString = sparqlCommunicator.performQuery(parameterizedQuery);
        StateResponse[] receivedObjects;
        receivedObjects = objectMapper.readValue(resultString, StateResponse[].class);
        return receivedObjects[0];
    }

    private int getFrameWithMostRivets(List<RivetPosition> rivetPositions) {
        int maxCount = 0;
        int maxFrame = 0;
        for (RivetPosition p : rivetPositions) {
            int frameIndex = p.getFrameIndex();
            int numOccurrence = (int) rivetPositions.stream().filter(r -> r.getFrameIndex() == frameIndex).count();
            if (numOccurrence > maxCount) {
                maxCount = numOccurrence;
                maxFrame = frameIndex;
            }
        }
        return maxFrame;
    }
}
