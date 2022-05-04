package de.dfki.cos.basys.common.pathfinding;

import com.jme3.math.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A* grid containing A* nodes.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class AStarGrid {

    int width, height;
    private AStarNode[][] grid;

    private Vector3f offset = new Vector3f(0,0,0);
    private float scaleFactor = 1.0f;

    /**
     * Constructs A* grid with A* nodes with given width and height.
     * All nodes are initially {@link AStarNode.NodeState#WALKABLE}
     *
     * @param width width
     * @param height height
     */
    public AStarGrid(int width, int height) {

        if (width < 1 || height < 1)
            throw new IllegalArgumentException("width and height cannot < 1");

        this.width = width;
        this.height = height;

        grid = new AStarNode[width][height];
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                grid[x][y] = new AStarNode(x, y, AStarNode.NodeState.WALKABLE);
            }
        }
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public Vector3f getOffset() {
        return offset;
    }

    public void setOffset(Vector3f offset) {
        this.offset = offset;
    }

    /**
     * @return grid width
     */
    public final int getWidth() {
        return width;
    }

    /**
     * @return grid height
     */
    public final int getHeight() {
        return height;
    }

    /**
     *
     * @param x x coord
     * @param y y coord
     * @return true IFF the point is within the grid
     */
    public final boolean isWithin(int x, int y) {
        return x >= 0 && x < getWidth()
                && y >= 0 && y < getHeight();
    }

    /**
     * Convenience method to set state of all nodes to given state.
     *
     * @param state node state
     */
    public final void setStateForAllNodes(AStarNode.NodeState state) {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                getNode(x, y).setState(state);
            }
        }
    }

    /**
     * Returns a node at x, y. There is no bounds checking.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return A* node at x, y
     */
    public final AStarNode getNode(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return grid[x][y];
        return null;
    }

    public final AStarNode getNodeFromWorldPoint(Vector3f worldPosition) {

        Vector3f gridPosition = worldPosition.subtract(offset).divide(scaleFactor);

        int x = Math.round(gridPosition.x);
        int y = Math.round(this.height - gridPosition.z); // important: z!

        return getNode(x,y);
    }

    public Vector3f getWorldPointFromNode(AStarNode node) {
        Vector3f worldPosition = new Vector3f(node.getX(), 0, this.height - node.getY()).mult(scaleFactor).add(offset);
        return worldPosition;
    }

    /**
     * @return a random node from the grid
     */
    public final AStarNode getRandomNode() {
        int x = (int) (Math.random() * getWidth());
        int y = (int) (Math.random() * getHeight());

        return getNode(x, y);
    }

    /**
     * @param predicate filter condition
     * @return a random node that passes the filter or {@link Optional#empty()}
     * if no such node exists
     */
    public final Optional<AStarNode> getRandomNode(Predicate<AStarNode> predicate) {
        List<AStarNode> filtered = getNodes().stream()
                .filter(predicate)
                .collect(Collectors.toList());

        if (filtered.isEmpty())
            return Optional.empty();

        int index = (int) (Math.random() * filtered.size());

        return Optional.of(filtered.get(index));
    }

    /**
     * @return underlying grid of nodes
     */
    public final AStarNode[][] getGrid() {
        return grid;
    }

    /**
     * @return all grid nodes
     */
    public final List<AStarNode> getNodes() {
        List<AStarNode> nodes = new ArrayList<>();

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                nodes.add(getNode(x, y));
            }
        }

        return nodes;
    }

    public List<AStarNode> getNeighbors(AStarNode node) {
        List<AStarNode> result = new ArrayList<>(8);

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;

                int checkX = node.getX() + x;
                int checkY = node.getY() + y;

                if (checkX >= 0 && checkX < getWidth() && checkY >= 0 && checkY < getHeight()) {
                    result.add(grid[checkX][checkY]);
                }
            }
        }

        return result;
    }

}
