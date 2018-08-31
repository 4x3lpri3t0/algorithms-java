package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<>();

    public Node (int d) {
        data = d;
    };
}