package de.dfki.cos.basys.common.pathfinding;

import java.util.Objects;

/**
 * Generic A* node.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class AStarNode implements Comparable<AStarNode> {

    public enum NodeState {
        WALKABLE, NOT_WALKABLE
    }

    private AStarNode parent;
    private NodeState state;
    private int x, y;
    private int gCost, hCost, movementPenalty;
    private Object userData = null;

    /**
     * Constructs A* node with x, y values and state.
     *
     * @param x x value
     * @param y y value
     * @param state initial state
     */
    public AStarNode(int x, int y, NodeState state) {
        this (x,y, state, 0);
    }

    /**
     * Constructs A* node with x, y values and state.
     *
     * @param x x value
     * @param y y value
     * @param state initial state
     * @param movementPenalty movement penalty
     */
    public AStarNode(int x, int y, NodeState state, int movementPenalty) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.movementPenalty = movementPenalty;
    }

    public final void setUserData(Object userData) {
        this.userData = userData;
    }

    public final Object getUserData() {
        return userData;
    }

    public final void setParent(AStarNode parent) {
        this.parent = parent;
    }

    public final AStarNode getParent() {
        return parent;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public final int getHCost() {
        return hCost;
    }

    final void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public final int getGCost() {
        return gCost;
    }

    public int getMovementPenalty() {
        return movementPenalty;
    }

    public void setMovementPenalty(int movementPenalty) {
        this.movementPenalty = movementPenalty;
    }

    public final int getFCost() {
        return gCost + hCost;
    }

    public final void setState(NodeState state) {
        this.state = state;
    }

    public final NodeState getState() {
        return state;
    }

    public boolean isWalkable() { return state == NodeState.WALKABLE; }

    @Override
    public String toString() {
        return "Node[x=" + x + ",y=" + y + " cost=" + getFCost() + "]";
    }

    @Override
    public int compareTo(AStarNode nodeToCompare) {
        int compare = Integer.compare(getFCost(), nodeToCompare.getFCost());
        if (compare == 0) {
            compare = Integer.compare(getHCost(), nodeToCompare.getHCost());
        }
        return compare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AStarNode aStarNode = (AStarNode) o;
        return x == aStarNode.x && y == aStarNode.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
