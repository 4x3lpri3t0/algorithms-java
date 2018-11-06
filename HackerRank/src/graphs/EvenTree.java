package graphs;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

// https://www.hackerrank.com/challenges/even-tree

public class EvenTree {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> edges = reader.lines()
                .map(l -> l.split(" "))
                .map(arr -> new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])})
                .collect(Collectors.toList());

        int[] nm = edges.remove(0);
        int N = nm[0];

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (Integer node : IntStream.rangeClosed(1, N).toArray()) {
            adjList.put(node, new ArrayList<>());
        }

        for (int[] edge : edges) {
            Integer from = edge[0];
            Integer to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        int numberOfRemovableEdges = 0;

        // Delete edges if both sub-trees have even numbers
        for (int[] edge : edges) {
            Integer from = edge[0];
            Integer to = edge[1];
            Set<Integer> forbiddenNodesLeft = new HashSet<>();
            forbiddenNodesLeft.add(from);
            Set<Integer> forbiddenNodesRight = new HashSet<>();
            forbiddenNodesRight.add(from);
            int countLeft = countNodes(from, adjList, forbiddenNodesLeft);
            int countRight = countNodes(to, adjList, forbiddenNodesRight);
            if (countLeft % 2 == 0 && countRight % 2 == 0) {
                numberOfRemovableEdges++;
                adjList.get(from).remove(to);
                adjList.get(to).remove(from);
            }
        }

        out.println(numberOfRemovableEdges);
    }

    private static int countNodes(Integer node, Map<Integer, List<Integer>> adjList, Set<Integer> visitedNodes) {
        List<Integer> children = adjList.get(node);
        visitedNodes.add(node);
        int nodeCount = 1;
        if (children.isEmpty()) {
            return nodeCount;
        }

        for (Integer child : children) {
            if (!visitedNodes.contains(child)) {
                nodeCount += countNodes(child, adjList, visitedNodes);
            }
        }

        return nodeCount;
    }
}