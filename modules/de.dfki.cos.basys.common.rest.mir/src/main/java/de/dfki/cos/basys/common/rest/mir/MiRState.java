package de.dfki.cos.basys.common.rest.mir;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MiRState {
    READY(3),
    PAUSED(4),
    EXECUTING(5),
    ABORTED(6),
    FINISHED(7),
    REJECTED(-1);

    private final int id;

    private static final Map<Integer, MiRState> mapping
            = new HashMap<Integer, MiRState>();

    static {
        for (MiRState s : EnumSet.allOf(MiRState.class))
            mapping.put(s.id(), s);
    }

    public int id() {
        return this.id;
    }

    public static MiRState get(int id) {
        return mapping.get(id);
    }

    MiRState(int id) {
        this.id = id;
    }

    public static MiRState mapRobotStates(String state) {
        switch (state) {
            case "Ready":
                return READY;

            case "Pause":
                return PAUSED;

            case "Executing":
                return EXECUTING;

            case "Aborted":
                return ABORTED;

            case "Done":
                return FINISHED;

            default:
                return REJECTED;
        }
    }

}
