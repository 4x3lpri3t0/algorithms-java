// Use a greedy approach to build up a correct solution in one pass through the nodes.
// This brought us close to the optimal runtime, but we also had to take last step of
// iterating over the colors only until we find a legal color.

// Sometimes stopping a loop like that is just a premature optimization that doesn't bring down
// the final runtime, but here it actually made our runtime linear.

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class _45_Graph_Coloring {
    private class GraphNode {

        private String label;
        private Set<GraphNode> neighbors;
        private Optional<String> color;

        public GraphNode(String label) {
            this.label = label;
            neighbors = new HashSet<>();
            color = Optional.empty();
        }

        String getLabel() {
            return label;
        }

        Set<GraphNode> getNeighbors() {
            return Collections.unmodifiableSet(neighbors);
        }

        public void addNeighbor(GraphNode neighbor) {
            neighbors.add(neighbor);
        }

        boolean hasColor() {
            return color.isPresent();
        }

        String getColor() {
            return color.get();
        }

        void setColor(String color) {
            this.color = Optional.ofNullable(color);
        }
    }

    public static void colorGraph(GraphNode[] graph, String[] colors) {
        for (GraphNode node : graph) {
            Set<GraphNode> neighbors = node.getNeighbors();

            if (neighbors.contains(node)) {
                throw new IllegalArgumentException(String.format(
                        "Legal coloring impossible for node with loop: %s",
                        node.getLabel()));
            }

            // Get the node's neighbors' colors, as a set so we
            // can check if a color is illegal in constant time
            Set<String> illegalColors = new HashSet<>();
            for (GraphNode neighbor : neighbors) {
                if (neighbor.hasColor()) {
                    illegalColors.add(neighbor.getColor());
                }
            }

            // Assign the first legal color
            for (String color : colors) {
                if (!illegalColors.contains(color)) {
                    node.setColor(color);
                    break;
                }
            }
        }
    }
}