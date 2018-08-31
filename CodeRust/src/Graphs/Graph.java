package Graphs;

import java.util.*;

import static java.lang.System.*;

public class Graph {
    private List<Vertex> g;   // Vertices
    private List<Edge> e;     // Edges

    public Graph(List<Vertex> g, List<Edge> e) {
        super();
        this.g = g;
        this.e = e;
    }

    public Graph(List<Vertex> g) {
        super();
        this.g = g;
    }

    public List<Vertex> getG() {
        return g;
    }

    public void setG(List<Vertex> g) {
        this.g = g;
    }

    public List<Edge> getE() {
        return e;
    }

    public void setE(List<Edge> e) {
        this.e = e;
    }

    // This method creates a graph from a list of words. A node of
    // the graph contains a character representing the start or end
    // character of a word.
    void create_graph(List<String> words_list) {
        for (int i = 0; i < words_list.size(); i++) {
            String word = words_list.get(i);
            char start_char = word.charAt(0);
            char end_char = word.charAt(word.length() - 1);

            Vertex start = vertexExists(start_char);
            if (start == null) {
                start = new Vertex(start_char, false);
                g.add(start);
            }

            Vertex end = vertexExists(end_char);
            if (end == null) {
                end = new Vertex(end_char, false);
                g.add(end);
            }

            // Add an edge from start vertex to end vertex
            add_edge(start, end);
        }
    }

    // This method adds an edge from start vertex to end vertex by
    // adding the end vertex in the adjacency list of start vertex
    // It also adds the start vertex to the in_vertices of end vertex
    void add_edge(Vertex start, Vertex end) {
        start.getAdj_vertices().add(end);
        end.getIn_vertices().add(start);
    }

    // This method returns TRUE if out degree of each vertex is equal
    // to its in degree, returns FALSE otherwise
    boolean out_equals_in() {
        for (int i = 0; i < getG().size(); i++) {
            int out = getG().get(i).getAdj_vertices().size();
            int in = getG().get(i).getIn_vertices().size();
            if (out != in) {
                return false;
            }
        }
        return true;
    }


    // This method returns TRUE if all nodes of the graph have
    // been visited
    boolean all_visited() {
        for (int i = 0; i < getG().size(); i++) {
            if (getG().get(i).isVisited() == false) {
                return false;
            }
        }
        return true;
    }

    // This method returns TRUE if the graph has a cycle containing
    // all the nodes, returns FALSE otherwise
    boolean check_cycle_rec(Vertex node, Vertex starting_node) {

        node.setVisited(true);

        // Base case
        // return TRUE if all nodes have been visited and there
        // exists an edge from the last node being visited to
        // the starting node
        List<Vertex> adj = node.getAdj_vertices();
        if (all_visited()) {
            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i) == starting_node) {
                    return true;
                }
            }
        }

        // Recursive case
        for (int i = 0; i < adj.size(); i++) {
            if (!adj.get(i).isVisited()) {
                node = adj.get(i);
                if (check_cycle_rec(node, starting_node)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean check_cycle(int list_size) {
        // Empty list and single word cannot form a chain
        if (list_size < 2) {
            return false;
        }

        if (g.size() > 0) {
            if (out_equals_in()) {
                return check_cycle_rec(getG().get(0), getG().get(0));
            }
        }
        return false;
    }

    // This method returns the vertex with a given id if it
    // already exists in the graph, returns NULL otherwise
    Vertex vertexExists(int id) {
        for (int i = 0; i < g.size(); i++) {
            if (g.get(i).getId() == id) {
                return g.get(i);
            }
        }
        return null;
    }

    // This method generates the graph with v vertices and e edges
    void generateGraph(int vertices, List<ArrayList<Integer>> edges) {
        // Create vertices
        for (int i = 0; i < vertices; i++) {
            Vertex v = new Vertex(i + 1, false);
            g.add(v);
        }

        // Create edges
        for (int i = 0; i < edges.size(); i++) {
            Vertex src = vertexExists(edges.get(i).get(1));
            Vertex dest = vertexExists(edges.get(i).get(2));
            Edge e = new Edge(edges.get(i).get(0), false, src, dest);
            getE().add(e);
        }
    }

    // This method finds the MST of a graph using Prim's Algorithm
    // Returns the weight of the MST
    int findMinSpanningTree() {
        int vertexCount = 0;
        int weight = 0;

        // Add first vertex to the MST
        Vertex current = g.get(0);
        current.setVisited(true);
        vertexCount++;

        // Construct the remaining MST using the smallest weight edge
        while (vertexCount < g.size()) {
            Edge smallest = null;
            for (Edge edge : e) {
                if (!edge.isVisited() && !edge.getDest().isVisited()) {
                    smallest = edge;
                    break;
                }
            }

            for (Edge edge : e) {
                if (!edge.isVisited()) {
                    if (edge.getSrc().isVisited()
                            && !edge.getDest().isVisited()
                            && (edge.getWeight() < smallest.getWeight())) {
                        smallest = edge;
                    }
                }
            }

            smallest.setVisited(true);
            smallest.getDest().setVisited(true);
            weight += smallest.getWeight();
            vertexCount++;
        }

        return weight;
    }

    void printGraph() {
        for (int i = 0; i < g.size(); i++) {
            out.println(
                    g.get(i).getId() + " " + g.get(i).isVisited());
        }
        out.println();
        for (int i = 0; i < e.size(); i++) {
            out.println(e.get(i).getSrc().getId() + "->"
                    + e.get(i).getDest().getId() + "["
                    + e.get(i).getWeight() + ", "
                    + e.get(i).isVisited() + "]  ");
        }
        out.println("\n");
    }

    void printMst(int w) {
        out.println("MST");
        for (Edge edge : e) {
            if (edge.isVisited()) {
                out.println(edge.getSrc().getId() + "->"
                        + edge.getDest().getId());
            }
        }

        out.println("weight: " + w);
        out.println();
    }

    private static Node cloneRec(
            Node root,
            HashMap<Node, Node> nodesCompleted) {

        if (root == null) {
            return null;
        }

        Node pNew = new Node(root.data);
        nodesCompleted.put(root, pNew);

        for (Node p : root.neighbors) {
            Node x = nodesCompleted.get(p);
            if (x == null) {
                pNew.neighbors.add(cloneRec(p, nodesCompleted));
            } else {
                pNew.neighbors.add(x);
            }
        }

        return pNew;
    }

    public static Node clone(Node root) {
        HashMap<Node, Node> nodesCompleted = new HashMap<>();

        return cloneRec(root, nodesCompleted);
    }
}