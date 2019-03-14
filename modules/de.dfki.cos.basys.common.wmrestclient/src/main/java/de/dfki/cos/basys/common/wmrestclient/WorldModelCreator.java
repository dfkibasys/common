package de.dfki.cos.basys.common.wmrestclient;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame;
import de.dfki.cos.basys.common.wmrestclient.dto.Frame.FrameType;
import de.dfki.cos.basys.common.wmrestclient.dto.Hull;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition.State;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldModelCreator {

    protected static final Logger LOGGER = LoggerFactory.getLogger(WorldModelRestClientImpl.class.getName());

    public static void ResetAllToEmpty(WorldModelRestClientImpl client) {
        String hullId = client.getHulls().get(0).getId();
        Hull hull = client.getHull(hullId);
        List<RivetPosition> allRivets = new LinkedList<>();
        for (Frame f : hull.getFrames()) {
            List<RivetPosition> rivetsInFrame = f.getRivetPositions();
            rivetsInFrame.stream().map((r) -> {
                r.setState(RivetPosition.State.EMPTY);
                return r;
            }).forEachOrdered((r) -> {
                client.updateRivetPosition(r);
            });
        }
    }

    /**
     *
     * @param fileName Path to csv file relative to the calling project (e.g.
     * 'resources/my_configuration.csv')
     * @param separator Separator character(s) to separate values in csv file
     * @param client WorldModelRestClient that is communicating with the roa
     * world server
     *
     * Example of usage from the application that imports WorkdModelCreator:
     * WorldModelCreate.SetStateFromFile('path/to/resourceofcallingapplication',
     * ';', client);
     *
     * @throws IOException
     *
     */
    public static void SetStateFromFile(String fileName, String separator, WorldModelRestClient client) throws IOException {

        String line;
        BufferedReader br;
        Hull hull = client.getHull(client.getHulls().get(0).getId());
        br = new BufferedReader(new FileReader(fileName));
        Map<Integer, Map<Integer, State>> rivetsByIndices = new HashMap<>();

        while ((line = br.readLine()) != null) {
            String[] rivetToSet = line.split(separator);
            int frameIndex = 0;
            int rivetIndex = 0;

            try {
                frameIndex = Integer.parseInt(rivetToSet[0]);
                rivetIndex = Integer.parseInt(rivetToSet[1]);
            } catch (NumberFormatException ex) {
                LOGGER.debug("FAILED TO INITIALIZE STATE OF RIVET AS INDEX VALUE COULD NOT BE PARSED");
                continue;
            }

            if (rivetsByIndices.get(frameIndex) == null) {
                rivetsByIndices.put(Integer.parseInt(rivetToSet[0]), new HashMap<>());
            }

            try {
                rivetsByIndices.get(Integer.parseInt(rivetToSet[0])).put(Integer.parseInt(rivetToSet[1]), State.valueOf(rivetToSet[2]));
            } catch (IllegalArgumentException ex) {
                LOGGER.debug(String.format("FAILED TO INITIALIZED STATE OF RIVET [%s | %s] AS STATE %s IS NO VALID STATE",
                        rivetToSet[0],
                        rivetToSet[1],
                        rivetToSet[2]));
            }
        }

        hull.getFrames().forEach((Frame f) -> {
            if (rivetsByIndices.containsKey(f.getIndex())) {
                f.getRivetPositions().forEach((RivetPosition r) -> {
                    if (rivetsByIndices.get(f.getIndex()).containsKey(r.getIndex())) {
                        r.setState(rivetsByIndices.get(f.getIndex()).get(r.getIndex()));
                    }
                    client.updateRivetPosition(r);
                });
            }
        });
    }

	public static Hull createHullHMI( ) {
		Hull hull = new Hull()
			.addFrame(new Frame( 1, FrameType.H_9x2))
			.addFrame(new Frame( 2, FrameType.H_9x2))
			.addFrame(new Frame( 3, FrameType.H_9x2))
			.addFrame(new Frame( 4, FrameType.H_9x2))
			.addFrame(new Frame( 5, FrameType.H_9x2))
			.addFrame(new Frame( 6, FrameType.H_9x2))
			.addFrame(new Frame( 7, FrameType.H_9x2))
			.addFrame(new Frame( 8, FrameType.H_9x2))
			.addFrame(new Frame( 9, FrameType.H_9x2))
			.addFrame(new Frame(10, FrameType.H_9x2))
			.addFrame(new Frame(11, FrameType.H_9x2))
			.addFrame(new Frame(12, FrameType.H_9x2))
			.addFrame(new Frame(13, FrameType.H_9x2))
			.addFrame(new Frame(14, FrameType.H_9x2))
			.addFrame(new Frame(15, FrameType.H_9x2))
			.addFrame(new Frame(16, FrameType.H_9x2))
			.addFrame(new Frame(17, FrameType.H_9x2))
			.addFrame(new Frame(18, FrameType.H_9x2))
			.addFrame(new Frame(19, FrameType.H_9x2))
			.addFrame(new Frame(20, FrameType.H_9x2))
			.addFrame(new Frame(21, FrameType.H_9x2))
			.addFrame(new Frame(22, FrameType.H_9x2))
			.addFrame(new Frame(23, FrameType.H_9x2))
			.addFrame(new Frame(24, FrameType.H_9x2))
			.addFrame(new Frame(25, FrameType.H_9x2))
			.addFrame(new Frame(26, FrameType.H_9x2))
			.addFrame(new Frame(27, FrameType.H_9x2))
			.addFrame(new Frame(28, FrameType.H_9x2))
			.addFrame(new Frame(29, FrameType.H_9x2))
			.addFrame(new Frame(30, FrameType.H_9x2))
			.addFrame(new Frame(31, FrameType.H_9x2))
			.addFrame(new Frame(32, FrameType.H_9x2))
			.addFrame(new Frame(33, FrameType.H_9x2))
			.addFrame(new Frame(34, FrameType.H_9x2))
			.addFrame(new Frame(35, FrameType.H_9x2))
			.addFrame(new Frame(36, FrameType.H_9x2))
			.addFrame(new Frame(37, FrameType.H_9x2))
			.addFrame(new Frame(38, FrameType.H_9x2))
			.addFrame(new Frame(39, FrameType.H_9x2))
			.addFrame(new Frame(40, FrameType.H_9x2))
			.addFrame(new Frame(41, FrameType.H_9x2))
			.addFrame(new Frame(42, FrameType.H_9x2))
			.addFrame(new Frame(43, FrameType.H_9x2))
			.addFrame(new Frame(44, FrameType.H_9x2))
			.addFrame(new Frame(45, FrameType.H_9x2))
			.addFrame(new Frame(101, FrameType.V_10x2))
			.addFrame(new Frame(102, FrameType.V_10x2))
			.addFrame(new Frame(103, FrameType.V_10x2))
			.addFrame(new Frame(104, FrameType.V_6x2))
			.addFrame(new Frame(105, FrameType.V_6x2))
			.addFrame(new Frame(106, FrameType.V_6x2))
			.addFrame(new Frame(107, FrameType.V_6x2))
			.addFrame(new Frame(108, FrameType.V_6x2))
			.addFrame(new Frame(109, FrameType.V_6x2))
			.addFrame(new Frame(110, FrameType.V_6x2))
			.addFrame(new Frame(111, FrameType.V_6x2))
			.addFrame(new Frame(112, FrameType.V_6x2));
		
		return hull;
	}
	
	public static Hull createHullHorizontalHMI( ) {
		Hull hull = new Hull()
			.addFrame(new Frame( 1, FrameType.H_8x2))
			.addFrame(new Frame( 2, FrameType.H_8x2))
			.addFrame(new Frame( 3, FrameType.H_8x2))
			.addFrame(new Frame( 4, FrameType.H_8x2))
			.addFrame(new Frame( 5, FrameType.H_8x2))
			.addFrame(new Frame( 6, FrameType.H_8x2))
			.addFrame(new Frame( 7, FrameType.H_8x2))
			.addFrame(new Frame( 8, FrameType.H_8x2))
			.addFrame(new Frame( 9, FrameType.H_8x2))
			.addFrame(new Frame(10, FrameType.H_8x2))
			.addFrame(new Frame(11, FrameType.H_8x2))
			.addFrame(new Frame(12, FrameType.H_8x2))
			.addFrame(new Frame(13, FrameType.H_8x2))
			.addFrame(new Frame(14, FrameType.H_8x2))
			.addFrame(new Frame(15, FrameType.H_8x2))
			.addFrame(new Frame(16, FrameType.H_8x2))
			.addFrame(new Frame(17, FrameType.H_8x2))
			.addFrame(new Frame(18, FrameType.H_8x2))
			.addFrame(new Frame(19, FrameType.H_8x2))
			.addFrame(new Frame(20, FrameType.H_8x2))
			.addFrame(new Frame(21, FrameType.H_8x2))
			.addFrame(new Frame(22, FrameType.H_8x2))
			.addFrame(new Frame(23, FrameType.H_8x2))
			.addFrame(new Frame(24, FrameType.H_8x2))
			.addFrame(new Frame(25, FrameType.H_8x2))
			.addFrame(new Frame(26, FrameType.H_8x2))
			.addFrame(new Frame(27, FrameType.H_8x2))
			.addFrame(new Frame(28, FrameType.H_8x2))
			.addFrame(new Frame(29, FrameType.H_8x2))
			.addFrame(new Frame(30, FrameType.H_8x2))
			.addFrame(new Frame(31, FrameType.H_8x2))
			.addFrame(new Frame(32, FrameType.H_8x2))
			.addFrame(new Frame(33, FrameType.H_8x2))
			.addFrame(new Frame(34, FrameType.H_8x2))
			.addFrame(new Frame(35, FrameType.H_8x2))
			.addFrame(new Frame(36, FrameType.H_8x2))
			.addFrame(new Frame(37, FrameType.H_8x2))
			.addFrame(new Frame(38, FrameType.H_8x2))
			.addFrame(new Frame(39, FrameType.H_8x2))
			.addFrame(new Frame(40, FrameType.H_8x2))
			.addFrame(new Frame(41, FrameType.H_8x2))
			.addFrame(new Frame(42, FrameType.H_8x2))
			.addFrame(new Frame(43, FrameType.H_8x2))
			.addFrame(new Frame(44, FrameType.H_8x2))
			.addFrame(new Frame(45, FrameType.H_8x2));
		
		return hull;
	}
}
