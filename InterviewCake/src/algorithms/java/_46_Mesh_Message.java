// We're using an ArrayDeque instead of an ArrayList because we want an
// efficient (FIFO) structure with O(1) inserts and removes.

// If we used an ArrayList, appending would be O(1), but removing
// elements from the front would be O(n).

import java.util.*;

public class _46_Mesh_Message {
    private static String[] reconstructPath(
            Map<String, String> previousNodes, String startNode, String endNode) {

        List<String> reversedShortestPath = new ArrayList<>();

        // Start from the end of the path and work backwards
        String currentNode = endNode;

        while (currentNode != null) {
            reversedShortestPath.add(currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        // Reverse our path to get the right order
        // by flipping it around, in place
        Collections.reverse(reversedShortestPath);
        return reversedShortestPath.toArray(new String[reversedShortestPath.size()]);
    }

    public static String[] bfsGetPath(Map<String, String[]> graph, String startNode, String endNode) {
        if (!graph.containsKey(startNode)) {
            throw new IllegalArgumentException("Start node not in graph");
        }
        if (!graph.containsKey(endNode)) {
            throw new IllegalArgumentException("End node not in graph");
        }

        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);

        // Keep track of how we got to each node
        // -> 1- Keep track of already visited nodes
        // -> 2- Reconstruct the shortest path at the end
        Map<String, String> nodePaths = new HashMap<>();
        nodePaths.put(startNode, null);

        while (!nodesToVisit.isEmpty()) {
            String currentNode = nodesToVisit.remove();

            // Stop when we reach the end node
            if (currentNode.equals(endNode)) {
                return reconstructPath(nodePaths, startNode, endNode);
            }

            for (String neighbor : graph.get(currentNode)) {
                if (!nodePaths.containsKey(neighbor)) {
                    nodesToVisit.add(neighbor);
                    nodePaths.put(neighbor, currentNode);
                }
            }
        }

        // If we get here, then we never found the end node
        // so there's NO path from startNode to endNode
        return null;
    }
}