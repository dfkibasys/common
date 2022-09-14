package de.dfki.cos.basys.common.pathfinding;

import de.dfki.cos.basys.common.pathfinding.AStarGrid;
import de.dfki.cos.basys.common.pathfinding.AStarNode;
import com.jme3.math.Vector3f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapUtils {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    private static final int RED   = 0xFFFF0000;
    private static final int GREEN = 0xFF00FF00;
    private static final int BLUE  = 0xFF0000FF;

    public static AStarGrid fromImageFile(String filename) {
        try {
            BufferedImage img = ImageIO.read(new File(filename));
            return fromImage(img);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AStarGrid fromResourceStream(InputStream is) {
        try {
            BufferedImage img = ImageIO.read(is);
            return fromImage(img);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AStarGrid fromImage(BufferedImage img) {
        AStarGrid grid = new AStarGrid(img.getWidth(), img.getHeight());
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                AStarNode node = grid.getNode(x, y);
                int rgb = img.getRGB(x,y);
                Color c = new Color(rgb);
                if (rgb == BLACK) {
                    node.setState(AStarNode.NodeState.NOT_WALKABLE);
                } else {
                    node.setState(AStarNode.NodeState.WALKABLE);
                    node.setMovementPenalty(255-c.getGreen());
                    //System.out.println(Integer.toHexString(rgb) + " --> " + c.getGreen());
                }
            }
        }
        return grid;
    }

    public static void toImageFile(AStarGrid grid, AStarNode startNode, AStarNode targetNode, List<AStarNode> path, String outputFilename) {

        try {
            BufferedImage img = new BufferedImage(grid.getWidth(), grid.getHeight(), BufferedImage.TYPE_INT_ARGB);
            for (AStarNode n : grid.getNodes()) {
                img.setRGB(n.getX(), n.getY(), !n.isWalkable() ? BLACK : WHITE);
            }

            for (AStarNode n : path) {
                paintNode(img, n, BLUE);
            }

            paintNode(img, startNode, GREEN);
            paintNode(img, targetNode, RED);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    img.setRGB(i,j,RED);
                }
            }

            ImageIO.write(img, "png", new File(outputFilename));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void toImageFile(AStarGrid grid, Vector3f start, Vector3f target, List<Vector3f> waypoints, String outputFilename) {
        AStarNode startNode = grid.getNodeFromWorldPoint(start);
        AStarNode targetNode = grid.getNodeFromWorldPoint(target);
        List<AStarNode> nodes = Collections.emptyList();
        if (waypoints != null) {
            nodes = new ArrayList<>(waypoints.size());
            for (Vector3f waypoint : waypoints) {
                AStarNode n = grid.getNodeFromWorldPoint(waypoint);
                if (n != null) {
                    nodes.add(n);
                }
            }
        }
        toImageFile(grid, startNode, targetNode, nodes, outputFilename);
    }

    private static void paintNode(BufferedImage img, AStarNode node, int color) {
        if (node == null) return;

        img.setRGB(node.getX()-1, node.getY()-1, color);
        img.setRGB(node.getX()-1, node.getY()+0, color);
        img.setRGB(node.getX()-1, node.getY()+1, color);
        img.setRGB(node.getX()+0, node.getY()-1, color);
        //img.setRGB(node.getX()+0, node.getY()+0, color);
        img.setRGB(node.getX()+0, node.getY()+1, color);
        img.setRGB(node.getX()+1, node.getY()-1, color);
        img.setRGB(node.getX()+1, node.getY()+0, color);
        img.setRGB(node.getX()+1, node.getY()+1, color);
    }
}
