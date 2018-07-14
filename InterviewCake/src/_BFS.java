import java.util.*;

public class _BFS {
    public static void bfs(Map<String, String[]> graph, String startNode, String endNode) {
        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);

        // Keep track of what nodes we've already seen
        // so we don't process them twice
        Set<String> seen = new HashSet<String>();
        seen.add(startNode);

        while (!nodesToVisit.isEmpty()) {
            String currentNode = nodesToVisit.remove();

            if (currentNode.equals(endNode)) {
                // Found it!
                break;
            }

            for (String neighbor: graph.get(currentNode)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    nodesToVisit.add(neighbor);
                }
            }
        }
    }
}
