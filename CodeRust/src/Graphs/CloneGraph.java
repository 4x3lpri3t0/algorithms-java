package Graphs;

import javafx.util.Pair;

import java.util.*;

import static java.lang.System.*;

public class CloneGraph {

    // If there is an edge from x to y
    // that means there must be an edge from y to x
    // and there is no edge from a node to itself
    // hence there can maximum of (nodes * nodes - nodes) / 2 edges in this graph
    static ArrayList<Node> createTestGraphUndirected(int nodesCount, int edgesCount) {
        ArrayList<Node> vertices = new ArrayList<>();
        for (int i = 0; i < nodesCount; ++i) {
            vertices.add(new Node(i));
        }

        List<Pair<Integer, Integer>> allEdges = new ArrayList<>();
        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = i + 1; j < vertices.size(); ++j) {
                allEdges.add(new Pair<>(i, j));
            }
        }

        Collections.shuffle(allEdges);

        for (int i = 0; i < edgesCount && i < allEdges.size(); ++i) {
            Pair<Integer, Integer> edge = allEdges.get(i);
            vertices.get(edge.getKey()).neighbors.add(vertices.get(edge.getValue()));
            vertices.get(edge.getValue()).neighbors.add(vertices.get(edge.getKey()));
        }

        return vertices;
    }

    static void printGraph(List<Node> vertices) {
        for (Node n : vertices) {
            out.print(n.data + ": {");
            for (Node t : n.neighbors) {
                out.print(t.data + " ");
            }
            out.println();
        }
    }

    static void printGraph(Node root, HashSet<Node> visitedNodes) {
        if (root == null || visitedNodes.contains(root)) {
            return;
        }

        visitedNodes.add(root);

        out.print(root.data + ": {");
        for (Node n : root.neighbors) {
            out.print(n.data + " ");
        }
        out.println("}");

        for (Node n : root.neighbors) {
            printGraph(n, visitedNodes);
        }
    }

    static void printGraph(Node root) {
        HashSet<Node> visitedNodes = new HashSet<>();
        printGraph(root, visitedNodes);
    }

    static boolean areGraphsEqualRec(Node root1, Node root2, HashSet<Node> visited) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        if (root1.neighbors.size() != root2.neighbors.size()) {
            return false;
        }

        for (Node nbr1 : root1.neighbors) {
            boolean found = false;
            for (Node nbr2 : root2.neighbors) {
                if (nbr1.data == nbr2.data) {
                    if (!visited.contains(nbr1)) {
                        visited.add(nbr1);
                        areGraphsEqualRec(nbr1, nbr2, visited);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Node> vertices = createTestGraphUndirected(7, 18);

        printGraph(vertices.get(0));

        Node cp = Graph.clone(vertices.get(0));
        out.println();
        out.println("After copy.");
        printGraph(cp);

        HashSet<Node> set = new HashSet<>();
        out.println(areGraphsEqualRec(vertices.get(0), cp, set));
    }
}