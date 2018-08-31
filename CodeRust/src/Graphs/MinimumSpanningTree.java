package Graphs;

import java.util.*;

import static java.lang.System.*;

public class MinimumSpanningTree {
    private static void test_graph1() {
        Graph g = new Graph(new ArrayList<>(), new ArrayList<>());
        int v = 5;

        // Each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(1, 1, 2));
        ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(2, 2, 3));
        ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(3, 2, 4));
        ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(3, 3, 5));
        ArrayList<Integer> e6 = new ArrayList<>(Arrays.asList(2, 4, 5));

        List<ArrayList<Integer>> e = new ArrayList<>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);

        g.generateGraph(v, e);
        out.println("Testing graph 1...");
        // g.printGraph();
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    private static void test_graph2() {
        Graph g = new Graph(new ArrayList<>(), new ArrayList<>());
        int v = 7;

        // Each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(2, 1, 4));
        ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(2, 1, 2));
        ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(1, 3, 4));
        ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(3, 2, 4));
        ArrayList<Integer> e6 = new ArrayList<>(Arrays.asList(2, 3, 5));
        ArrayList<Integer> e7 = new ArrayList<>(Arrays.asList(2, 4, 7));
        ArrayList<Integer> e8 = new ArrayList<>(Arrays.asList(1, 5, 6));
        ArrayList<Integer> e9 = new ArrayList<>(Arrays.asList(2, 5, 7));

        List<ArrayList<Integer>> e = new ArrayList<>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);
        e.add(e7);
        e.add(e8);
        e.add(e9);

        g.generateGraph(v, e);
        out.println("Testing graph 2...");
        // g.printGraph();
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    public static void main(String[] args) {
        test_graph1();
        test_graph2();

        out.println("Completed!");
    }
}