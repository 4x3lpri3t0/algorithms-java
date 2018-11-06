import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;
import static java.lang.System.out;

public class Main {
    class Network {
        private class Node {
            int id;
            double x;
            double y;
            double z;
            List<Integer> adjacentNodes;

            Node(int id, double x, double y, double z) {
                this.id = id;
                this.x = x;
                this.y = y;
                this.z = z;
                adjacentNodes = new ArrayList<>();
            }
        }

        int n;
        double connectivityDegree;
        double maxDistance;
        List<Node> nodes;

        Network(int n, double connectivityDegree, double minX, double maxX, double minY, double maxY, double minZ, double maxZ) {
            this.n = n;
            this.connectivityDegree = connectivityDegree;
            this.maxDistance = sqrt(pow(maxX - minX, 2) + pow(maxY - minY, 2));
            this.nodes = new ArrayList<>();

            for (int id = 0; id < n; id++) {
                Random r = new Random();
                double randomX = minX + (maxX - minX) * r.nextDouble();
                double randomY = minY + (maxY - minY) * r.nextDouble();
                double randomZ = minZ + (maxZ - minZ) * r.nextDouble();
                Node node = new Node(id, randomX, randomY, randomZ);
                nodes.add(node);
            }

            // Generate adjacent nodes
            for (Node node : nodes) {
                node.adjacentNodes = generateNeighbors(node);
            }
        }

        private ArrayList<Integer> generateNeighbors(Node currentNode) {
            ArrayList<Integer> adjacentNodes = new ArrayList<>();

            for (Node node : nodes) {
                double distance = sqrt(pow(currentNode.x - node.x, 2) + pow(currentNode.y - node.y, 2));
                boolean alreadyNeighbors = node.adjacentNodes.contains(currentNode.id);

                if (node.id != currentNode.id
                        && !alreadyNeighbors
                        && arePossibleNeighbors(distance)) {

                    adjacentNodes.add(node.id);
                }
            }

            return adjacentNodes;
        }
        
        private boolean arePossibleNeighbors(double distance) {
            // From 0 to 1, 1 being the closest possible.
            double distanceFactor = 1 - (distance / maxDistance);

            // Exponential distribution
            double connectionProbability = 1 - (log(distanceFactor) * -1);

            return connectionProbability > connectivityDegree;
        }

        private void printPositions() {
            for (Node node : nodes) {
                // TODO: Change 1 for node.z
                out.println(String.format("%.2f,%.2f,%.2f", node.x, node.y, node.z));
            }
        }

        private void printNeighbors() {
            for (Node node : nodes) {
                for (int neighborId : node.adjacentNodes) {
                    out.println(String.format("%d,%d", node.id, neighborId));
                }
            }
        }
    }

    void generateNetwork(
            int n, double connectivityDegree, double maxX, double maxY, double maxZ) {
        Network network = new Network(n, connectivityDegree, 0, maxX, 0, maxY, 0, maxZ);
        network.printPositions();
        network.printNeighbors();
    }

    // Driver program
    public static void main(String[] args) {
        int N = 30;
        // 0 <= x <= 1, 0 being absolute connection
        double connectivityDegree = 0.75;
        double maxX = 100;
        double maxY = 100;
        double maxZ = 5;

        new Main().generateNetwork(N, connectivityDegree, maxX, maxY, maxZ);
    }
}