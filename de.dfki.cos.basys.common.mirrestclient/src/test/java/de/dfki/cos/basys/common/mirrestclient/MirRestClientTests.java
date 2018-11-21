package de.dfki.cos.basys.common.mirrestclient;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.dfki.cos.basys.common.mirrestclient.MiRState;
import de.dfki.cos.basys.common.mirrestclient.MirRestClient;
import de.dfki.cos.basys.common.mirrestclient.MirRestClientImpl;
import de.dfki.cos.basys.common.mirrestclient.dto.MissionDefinition;
import de.dfki.cos.basys.common.mirrestclient.dto.MissionInstance;
import de.dfki.cos.basys.common.mirrestclient.dto.MissionInstanceInfo;
import de.dfki.cos.basys.common.mirrestclient.dto.Status;
import de.dfki.cos.basys.common.mirrestclient.dto.SymbolicPosition;
import de.dfki.cos.basys.common.mirrestclient.dto.SymbolicPositionInfo;


public class MirRestClientTests {

	MirRestClient client;
	String url = "http://robot-mir-01.mrk40.dfki.lan";
	String auth = "YWRtaW46OGM2OTc2ZTViNTQxMDQxNWJkZTkwOGJkNGRlZTE1ZGZiMTY3YTljODczZmM0YmI4YTgxZjZmMmFiNDQ4YTkxOA==";
	
	@Before
	public void setUp() throws Exception {
		client = new MirRestClientImpl(url, auth);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStatus() {
		Status status = client.getRobotStatus();
		assertNotNull(status);
		assertEquals("MiR_R197",status.robot_name);
	}
	
	@Test
	public void testSetStatus() {
		Status status = client.setRobotStatus(MiRState.PAUSED);
		assertNotNull(status);
		assertEquals("MiR_R197",status.robot_name);
		assertEquals(MiRState.PAUSED.id(),status.state_id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		status = client.setRobotStatus(MiRState.READY);
		assertNotNull(status);
		assertEquals("MiR_R197",status.robot_name);
		assertEquals(MiRState.READY.id(),status.state_id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		status = client.setRobotStatus(MiRState.PAUSED);
		assertNotNull(status);
		assertEquals("MiR_R197",status.robot_name);
		assertEquals(MiRState.PAUSED.id(),status.state_id);
	}
	

	@Test
	public void testGetMissionDefinitions() {
		List<MissionDefinition> missionDefinitions = client.getMissionDefinitions();
		assertNotNull(missionDefinitions);
	}

	@Test
	public void testGetAllMissionInstancesInQueue() {
		List<MissionInstance> missionInstances = client.getAllMissionInstancesInQueue();
		assertNotNull(missionInstances);
	}
	
	@Test
	public void testGetMissionInstanceInfo() {
		MissionInstanceInfo info = client.getMissionInstanceInfo(666);
		assertNotNull(info);
	}

	@Test
	public void testGetPositions() {
		List<SymbolicPosition> positions = client.getPositions();
		assertNotNull(positions);
	}
	
	@Test
	public void testGetMapPositions() {
		String mapId = "605911f3-dc39-11e8-8b31-f44d3061d5d6";
		List<SymbolicPosition> positions = client.getMapPositions(mapId);
		assertNotNull(positions);
	}
	
	@Test
	public void testGetPositionInfo() {
		String positionId = "4300e514-e113-11e8-b57c-f44d3061d5d6";
		SymbolicPositionInfo info = client.getPositionInfo(positionId);
		assertNotNull(info);
		assertEquals("ColaStation", info.name);
	}
	
/*
{
   "allowed_methods": [
       "PUT",
       "GET",
       "DELETE"
   ],
   "created_by": "/v2.0.0/users/mirconst-guid-0000-0005-users0000000",
   "created_by_id": "mirconst-guid-0000-0005-users0000000",
   "created_by_name": "Administrator",
   "docking_offsets": "/v2.0.0/positions/a7813fb9-a6bd-11e8-8661-f44d3061d5d6/docking_offsets",
   "guid": "a7813fb9-a6bd-11e8-8661-f44d3061d5d6",
   "help_positions": "/v2.0.0/positions/a7813fb9-a6bd-11e8-8661-f44d3061d5d6/helper_positions",
   "map": "/v2.0.0/maps/d0a136fd-9676-11e8-8b15-f44d3061d5d6",
   "map_id": "d0a136fd-9676-11e8-8b15-f44d3061d5d6",
   "name": "Station-Cola",
   "orientation": 101.565,
   "parent": null,
   "parent_id": null,
   "pos_x": 26.117,
   "pos_y": 13.387,
   "type": "/v2.0.0/position_types/0",
   "type_id": 0 
}
*/
	
	@Test
	@Ignore
	public void testGotoColaStationSymbolic() {
		String positionName = "Station-Cola";
		MissionInstanceInfo instance = client.gotoSymbolicPosition(positionName);
		assertNotNull(instance);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.dequeueMissionInstance(instance.id);
	}
	
	@Test
	@Ignore
	public void testGotoColaStationAbsolute() {
		MissionInstanceInfo instance = client.gotoAbsolutePosition(26.117f, 13.387f, 101.565f);
		assertNotNull(instance);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.dequeueMissionInstance(instance.id);
	}
	
	
	@Test
	@Ignore
	public void testEnqueueDequeueMission() {
		String missionDefinitionId = "a32d83e6-e43a-11e8-aae5-f44d3061d5d6"; //restTest
		MissionInstanceInfo instance = client.enqueueMissionInstance(missionDefinitionId);
		assertNotNull(instance);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.dequeueMissionInstance(instance.id);
	}
}
