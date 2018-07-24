import java.io.*;
import java.util.*;

public class _4_2_IsThereARoute {
    public static void main() {
        Graph g = createNewGraph();
        GraphNode[] n = g.getNodes();
        GraphNode start = n[3];
        GraphNode end = n[5];
        System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        GraphNode[] temp = new GraphNode[6];

        temp[0] = new GraphNode("a", 3);
        temp[1] = new GraphNode("b", 0);
        temp[2] = new GraphNode("c", 0);
        temp[3] = new GraphNode("d", 1);
        temp[4] = new GraphNode("e", 1);
        temp[5] = new GraphNode("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    private static boolean search(Graph g, GraphNode start, GraphNode end) {
        LinkedList<GraphNode> q = new LinkedList<>();
        for (GraphNode node : g.getNodes()) {
            node.state = State.Unvisited;
        }

        start.state = State.Visited;
        q.add(start);

        while (!q.isEmpty()) {
            GraphNode u = q.removeFirst();
            if (u != null) {
                for (GraphNode v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            q.add(v);
                        }
                    }
                }
            }

            u.state = State.Visited;
        }

        return false;
    }
}