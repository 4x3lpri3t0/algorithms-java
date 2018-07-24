import static java.lang.System.out;

public class GraphNode {
    private GraphNode[] adjacent;
    private String vertex;
    public int adjacentCount;
    public State state;

    public GraphNode(String vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new GraphNode[adjacentLength];
    }

    public void addAdjacent(GraphNode x) {
        if (adjacentCount < 30) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            out.println("No more adjacent can be added");
        }
    }

    public GraphNode[] getAdjacent() {
        return adjacent;
    }

    public String getVertex() {
        return vertex;
    }
}