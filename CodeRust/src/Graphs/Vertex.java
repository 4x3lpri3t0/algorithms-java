package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int id;
    private boolean visited;
    private char value;
    private List<Vertex> adj_vertices;
    private List<Vertex> in_vertices;

    public Vertex(int id, boolean visited) {
        this.id = id;
        this.visited = visited;
    }

    public Vertex(char value, boolean visited) {
        this.value = value;
        this.visited = visited;
        this.adj_vertices = new ArrayList<>();
        this.in_vertices = new ArrayList<>();
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }

    List<Vertex> getAdj_vertices() {
        return this.adj_vertices;
    }

    List<Vertex> getIn_vertices() {
        return this.in_vertices;
    }
}