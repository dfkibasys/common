package de.dfki.cos.basys.common.mirrestclient;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import de.dfki.cos.basys.common.mirrestclient.dto.MissionDefinition;
import de.dfki.cos.basys.common.mirrestclient.dto.MissionInstance;
import de.dfki.cos.basys.common.mirrestclient.dto.MissionInstanceInfo;
import de.dfki.cos.basys.common.mirrestclient.dto.MissionOrder;
import de.dfki.cos.basys.common.mirrestclient.dto.Parameter;
import de.dfki.cos.basys.common.mirrestclient.dto.Status;
import de.dfki.cos.basys.common.mirrestclient.dto.StatusChangeRequest;
import de.dfki.cos.basys.common.mirrestclient.dto.SymbolicPosition;
import de.dfki.cos.basys.common.mirrestclient.dto.SymbolicPositionInfo;

public class MirRestService implements MirService {

	protected final Logger LOGGER = LoggerFactory.getLogger(MirRestService.class.getName());

	private final String pathSegment = "/api/v2.0.0";
	private final String gotoAbsolutePositionId = "mirconst-guid-0000-0003-actionlist00"; // id for MIR's default taxi mission;
	private final String gotoSymbolicPositionId = "mirconst-guid-0000-0001-actionlist00";// id for MIR's default move mission;
	
	protected Client client = ClientBuilder.newClient();
	protected WebTarget endpoint = null;
	protected String auth = null;
	
	List<MissionDefinition> missionDefinitions;
	Map<String,List<MissionDefinition>> areaMissionDefinitions = new HashMap<String, List<MissionDefinition>>();
	List<MissionInstance> allMissionInstances;
	List<MissionInstance> currentMissionInstances;	
	
	public MirRestService(String host, String auth) {
		this.endpoint = client.target(host).path(pathSegment);	
		this.auth = auth;
		init();
	}
	
	public MirRestService(WebTarget endpoint, String auth) {
		this.endpoint = endpoint.path(pathSegment);	
		this.auth = auth;
		init();
	}
	
	private void init() {
		missionDefinitions = getMissionDefinitions();
		allMissionInstances = getAllMissionInstancesInQueue();
		currentMissionInstances = new LinkedList<MissionInstance>();
	}
	
	@Override
	public Status getRobotStatus() {
		Status status = endpoint.path("/status").request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(Status.class);
		return status;
	}

	@Override
	public Status setRobotStatus(MiRState state) {
		
		StatusChangeRequest request = new StatusChangeRequest();
		request.state_id = state.id();
		
		Status status = endpoint.path("/status").request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).put(Entity.entity(request, MediaType.APPLICATION_JSON),Status.class);
		return status;
	}

	@Override
	public List<MissionDefinition> getMissionDefinitions() {
		if (missionDefinitions == null) {
			missionDefinitions = endpoint.path("/missions").request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(new GenericType<List<MissionDefinition>>() {});
		}
		return missionDefinitions;
	}

	@Override
	public List<MissionDefinition> getMissionDefinitionsInArea(String areaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MissionInstance> getAllMissionInstancesInQueue() {
		if (allMissionInstances == null) {
			allMissionInstances = endpoint.path("/mission_queue").request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(new GenericType<List<MissionInstance>>() {});
		}
		return allMissionInstances;
	}

	@Override
	public MissionInstanceInfo getMissionInstanceInfo( int missionInstanceId) {
		MissionInstanceInfo info = endpoint.path("/mission_queue/{id}").resolveTemplate("id", missionInstanceId).request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(MissionInstanceInfo.class);
		return info;
	}

	@Override
	public MissionInstanceInfo enqueueMissionInstance(MissionOrder order) {
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			String jsonInString = mapper.writeValueAsString(order);
//			LOGGER.debug(jsonInString);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		MissionInstanceInfo instance = endpoint.path("/mission_queue").request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth)
				.post(Entity.entity(order, MediaType.APPLICATION_JSON),MissionInstanceInfo.class);
		
		if (instance != null) {
			MissionInstance inst = instance.toMissionInstance();
			allMissionInstances.add(inst);
			currentMissionInstances.add(inst);				
		}
		return instance;
	}
	
	@Override
	public boolean dequeueMissionInstance(int missionInstanceId) {

		Response response = endpoint.path("/mission_queue/{id}").resolveTemplate("id", missionInstanceId).request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).delete();

		if (response.getStatus() == 200) {		
			//identify MissionInstance object in list
			MissionInstance instance = null;
			for (MissionInstance missionInstance : currentMissionInstances) {
				if (missionInstance.id == missionInstanceId) {
					instance = missionInstance;
	        		break; 
	        	}     
			}		
	        
	        if (instance != null) {
	        	allMissionInstances.remove(instance);
	        	currentMissionInstances.remove(instance);
	        }
	        
	        return true;
		}
        
        return false;
    
	}

	@Override
	public List<SymbolicPosition> getPositions() {
		List<SymbolicPosition> positions = endpoint.path("/positions").request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(new GenericType<List<SymbolicPosition>>() {});
		return positions;	
	}

	@Override
	public List<SymbolicPosition> getMapPositions( String mapId) {
		List<SymbolicPosition> positions = endpoint.path("/maps/{map_id}/positions").resolveTemplate("map_id", mapId).request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(new GenericType<List<SymbolicPosition>>() {});
		return positions;
	}
	
	@Override
	public SymbolicPositionInfo getPositionInfo(String positionId) {
		SymbolicPositionInfo info = endpoint.path("/positions/{id}").resolveTemplate("id", positionId).request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + auth).get(SymbolicPositionInfo.class);
		return info;	
	}

	@Override
	public List<MissionInstance> getMissionInstancesInQueue() {		
		List<MissionInstance> toRemove = new LinkedList<MissionInstance>();
		for (MissionInstance missionInstance : currentMissionInstances) {
			MissionInstanceInfo info = getMissionInstanceInfo(missionInstance.id);
			if (info.state.equalsIgnoreCase("finished") || info.state.equalsIgnoreCase("failed")) {
				toRemove.add(missionInstance);
			}
		}
		currentMissionInstances.removeAll(toRemove);			
		return currentMissionInstances;
	}
	
	@Override
	public MissionInstanceInfo enqueueMissionInstance(String missionDefinitionId) {
		MissionOrder order = new MissionOrder(missionDefinitionId, "");
		order.mission_id = missionDefinitionId;
		return enqueueMissionInstance(order);
	}
	
	@Override
	public MissionInstanceInfo enqueueMissionInstanceByName(String missionDefinitionName) {
		MissionDefinition missionDefinition = null;
		for (MissionDefinition m : missionDefinitions) {
			if (m.name.equals(missionDefinitionName)) {
				missionDefinition = m;
				break;
			}			
		}
		if (missionDefinition != null) {		
			return enqueueMissionInstance(missionDefinition.guid);
		} else {
			return null;
		}
	}

	@Override
	public MissionInstanceInfo gotoSymbolicPosition(String positionName) {
		SymbolicPosition position = null;
		List<SymbolicPosition> positions = getCurrentMapPositions();
		for (SymbolicPosition symbolicPosition : positions) {
			if (symbolicPosition.name.equals(positionName)) {
				position = symbolicPosition;
				break;
			}			
		}
		
		if (position != null) {
			MissionOrder order = new MissionOrder(gotoSymbolicPositionId, "");
			Parameter p = new Parameter();
			p.id = "Position";
			p.label = position.name;
			p.value = position.guid;
			order.parameters.add(p);
			return enqueueMissionInstance(order);
		}
		return null;
	}
	
	@Override
	public MissionInstanceInfo gotoAbsolutePosition(float posX, float posY, float orientation) {
		MissionOrder order = new MissionOrder(gotoAbsolutePositionId, "");
		Parameter x = new Parameter();
		x.id = "X";
		x.label = "X";
		x.value = posX;
		
		Parameter y = new Parameter();
		y.id = "Y";
		y.label = "Y";
		y.value = posY;
		
		Parameter o = new Parameter();
		o.id = "Orientation";
		o.label = "Orientation";
		o.value = orientation;

		order.parameters.add(x);
		order.parameters.add(y);
		order.parameters.add(o);
		
		return enqueueMissionInstance(order);

	}
	
	@Override
	public List<SymbolicPosition> getCurrentMapPositions() {
		Status status = getRobotStatus();
		return getMapPositions(status.map_id);		
	}

	@Override
	public boolean isQueueEmpty() {
		if (getMissionInstancesInQueue().size() > 0) {
			return false;
		} else { 
			return true;
		}
	}

	@Override
	public boolean isMissionInQueue(String missionDefinitionId) {
		// TODO Auto-generated method stub
		// Daniel: Do we need this?
		
		return false;
	}





}
