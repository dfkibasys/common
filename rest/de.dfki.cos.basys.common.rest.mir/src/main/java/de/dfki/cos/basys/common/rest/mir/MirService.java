package de.dfki.cos.basys.common.rest.mir;

import java.util.List;

import de.dfki.cos.basys.common.rest.mir.dto.MissionDefinition;
import de.dfki.cos.basys.common.rest.mir.dto.MissionInstance;
import de.dfki.cos.basys.common.rest.mir.dto.MissionInstanceInfo;
import de.dfki.cos.basys.common.rest.mir.dto.MissionOrder;
import de.dfki.cos.basys.common.rest.mir.dto.Status;
import de.dfki.cos.basys.common.rest.mir.dto.SymbolicPosition;
import de.dfki.cos.basys.common.rest.mir.dto.SymbolicPositionInfo;

public interface MirService {

	// atomic base functions -> REST calls
	
	Status getRobotStatus();	
	Status setRobotStatus(MiRState state);

	List<MissionDefinition> getMissionDefinitions();

	List<MissionDefinition> getMissionDefinitionsInArea(String areaId);

	List<MissionInstance> getAllMissionInstancesInQueue(); //INCLUDING HISTORIC ONES
	
	MissionInstanceInfo getMissionInstanceInfo(int missionInstanceId);

	MissionInstanceInfo enqueueMissionInstance(MissionOrder order);
	
	boolean dequeueMissionInstance(int missionInstanceId);


	List<SymbolicPosition> getPositions();
	List<SymbolicPosition> getMapPositions(String mapId);
	SymbolicPositionInfo getPositionInfo(String positionId);
	
	// tool and composed functions, syntactic sugar -> use base functions or cached results

	List<MissionInstance> getMissionInstancesInQueue(); // ONLY EXECUTING OR WAITING

	MissionInstanceInfo enqueueMissionInstance(String missionDefinitionId);
	MissionInstanceInfo enqueueMissionInstanceByName(String missionDefinitionName);
	MissionInstanceInfo gotoSymbolicPosition(String positionName);
	MissionInstanceInfo gotoAbsolutePosition(float posX, float posY, float orientation);
	
	List<SymbolicPosition> getCurrentMapPositions();
	
	boolean isQueueEmpty();

	boolean isMissionInQueue(String missionDefinitionId);
	



	

}