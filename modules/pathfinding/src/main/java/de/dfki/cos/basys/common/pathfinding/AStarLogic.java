package de.dfki.cos.basys.common.pathfinding;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

import java.util.*;

/**
 * A* search logic.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class AStarLogic {

    protected final AStarGrid grid;

    public AStarLogic(AStarGrid grid) {
        this.grid = grid;
    }

    public final List<Vector3f> getWaypoints(Vector3f start, Vector3f target) {
        List<AStarNode> nodes = getPath(grid.getNodeFromWorldPoint(start), grid.getNodeFromWorldPoint(target), true);
        if (nodes == null) return null;

        List<Vector3f> waypoints = new ArrayList<>(nodes.size());
        for (AStarNode node : nodes) {
            Vector3f waypoint = grid.getWorldPointFromNode(node);
            waypoints.add(waypoint);
        }
        return waypoints;
    }

    /**
     * Returns a (simplified) list of A* nodes from start to target.
     * The list will include target.
     * Return an empty list if the path doesn't exist.
     *
     * @param startX start node x
     * @param startY start node y
     * @param targetX target node x
     * @param targetY target node y
     * @return the path
     */
    public final List<AStarNode> getPath(int startX, int startY, int targetX, int targetY) {
        return getPath(startX, startY, targetX, targetY, true);
    }

    /**
     * Returns a list of A* nodes from start to target.
     * The list will include target.
     * Return an empty list if the path doesn't exist.
     *
     * @param startX start node x
     * @param startY start node y
     * @param targetX target node x
     * @param targetY target node y
     * @param simplify simplify the resulting path
     * @return the path
     */
    public final List<AStarNode> getPath(int startX, int startY, int targetX, int targetY, boolean simplify) {
        return getPath(grid.getNode(startX, startY), grid.getNode(targetX, targetY), simplify);
    }

    /**
     * Since the equality check is based on references,
     * start and target must be elements of the array.
     *
     * @param startNode     starting node
     * @param targetNode    target node
     * @param busyNodes busy "unwalkable" nodes
     * @return          path as list of nodes from start to target or null if no path found
     */
    public final List<AStarNode> getPath(AStarNode startNode, AStarNode targetNode, boolean simplify, AStarNode... busyNodes) {

        boolean found = false;
        startNode.setParent(startNode);
        int i = 0;

        List<AStarNode> closedSet = new ArrayList<>();
        if (startNode.isWalkable() && targetNode.isWalkable()) {
            PriorityQueue<AStarNode> openSet = new PriorityQueue<>(grid.getWidth()*grid.getHeight());
            openSet.add(startNode);

            while (openSet.size() > 0) {

                //System.out.println("open set (count:" + openSet.size() + ") : " + openSet);

                AStarNode currentNode = openSet.remove();
                closedSet.add(currentNode);

                if (currentNode == targetNode) {
                    found = true;
                    break;
                }

                for (AStarNode neighbour : getValidNeighbors(currentNode, busyNodes)) {
                    if (closedSet.contains(neighbour)) {
                        continue;
                    }

                    int newMovementCostToNeighbour = currentNode.getGCost() + getDistance(currentNode, neighbour) + neighbour.getMovementPenalty();
                    if (newMovementCostToNeighbour <= neighbour.getGCost() || !openSet.contains(neighbour)) {
                        neighbour.setGCost(newMovementCostToNeighbour);
                        neighbour.setHCost(getDistance(neighbour, targetNode));
                        neighbour.setParent(currentNode);

                        if (openSet.contains(neighbour)) {
                            openSet.remove(neighbour);
                        }
                        openSet.add(neighbour);
                    }
                }
            }
        }
        if (found) {
            //System.out.println("FOUND");
            return buildPath(startNode, targetNode, simplify);
        }
        else {
            //System.out.println("NOT_FOUND");
            //return Collections.emptyList();
            return null;
            //return closedSet;
        }
    }

    private List<AStarNode> buildPath(AStarNode start, AStarNode target, boolean simplify) {
         List<AStarNode> path = new ArrayList<>();

        AStarNode tmp = target;
        do {
            path.add(tmp);
            tmp = tmp.getParent();
        } while (tmp != start);

        if (simplify) {
            path = simplifyPath(path);
        }

        Collections.reverse(path);
        return path;
    }

    private List<AStarNode> simplifyPath(List<AStarNode> path) {
        List<AStarNode> result = new ArrayList<>();

        Vector2f directionOld = Vector2f.ZERO;

        for (int i = 1; i < path.size(); i ++) {
            Vector2f directionNew = new Vector2f(path.get(i-1).getX() - path.get(i).getX(),path.get(i-1).getY() - path.get(i).getY());
            if (!directionNew.equals(directionOld)) {
                result.add(path.get(i));
            }
            directionOld = directionNew;
        }

        return result;
    }


    /**
     * @param node the A* node
     * @param busyNodes nodes which are busy, i.e. walkable but have a temporary obstacle
     * @return neighbors of the node
     */
    protected List<AStarNode> getValidNeighbors(AStarNode node, AStarNode... busyNodes) {
        List<AStarNode> neighbors = grid.getNeighbors(node);
        List<AStarNode> result = new ArrayList<>();

        for (AStarNode n : neighbors) {
            if (n.isWalkable() && Arrays.stream(busyNodes).noneMatch(b -> b.getX() == n.getX() && b.getY() == n.getX())) {
                result.add(n);
            }
        }
        //System.out.println("return valid neighbours: " + result.size());
        return result;
    }

    private int getDistance(AStarNode nodeA, AStarNode nodeB) {
        int dstX = Math.abs(nodeA.getX() - nodeB.getX());
        int dstY = Math.abs(nodeA.getY() - nodeB.getY());

        if (dstX > dstY)
            return 14*dstY + 10* (dstX-dstY);
        return 14*dstX + 10 * (dstY-dstX);
    }

}
