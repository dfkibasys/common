package de.dfki.cos.basys.common.wmrestclient.dto;

import java.util.UUID;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame.FrameType;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;

public class RivetPosition {

    public enum State {
        UNDEFINED, EMPTY, SQUEEZING, SQUEEZED, CHECKING, CHECKED_IO, CHECKED_NIO, SEALING, SEALED
    }

    // a UUID
    String id;

    //parent frame
    String parentId;

    // logical coordinates
    int frameIndex; // global!
    FrameType frameType;
    int index;

    // current state
    State state;
    String stateAttributeUri;

    String resourceUri;

    public RivetPosition(int index) {
        this(UUID.randomUUID().toString(), index);
    }

    public RivetPosition(String id, int index) {
        this.id = id;
        this.index = index;
        this.state = State.EMPTY;
    }

    public RivetPosition(String id, String uri, int index) {
        this(id, index);
        resourceUri = uri;
    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public int getFrameIndex() {
        return frameIndex;
    }

    public RivetPosition setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
        return this;
    }

    public FrameType getFrameType() {
        return frameType;
    }

    public RivetPosition setFrameType(FrameType frameType) {
        this.frameType = frameType;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public RivetPosition setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public State getState() {
        return state;
    }

    public RivetPosition setState(State state) {
        this.state = state;
        return this;
    }

    public void setStateAttributeUri(String uri) {
        stateAttributeUri = uri;
    }

}
