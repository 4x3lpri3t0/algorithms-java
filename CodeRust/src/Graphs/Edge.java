package Graphs;

public class Edge {
    private int weight;
    private boolean visited;
    private Vertex src;
    private Vertex dest;

    public Edge(int weight, boolean visited, Vertex src, Vertex dest) {
        this.weight = weight;
        this.visited = visited;
        this.src = src;
        this.dest = dest;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }

    Vertex getSrc() {
        return src;
    }

    void setSrc(Vertex src) {
        this.src = src;
    }

    Vertex getDest() {
        return dest;
    }

    void setDest(Vertex dest) {
        this.dest = dest;
    }
}