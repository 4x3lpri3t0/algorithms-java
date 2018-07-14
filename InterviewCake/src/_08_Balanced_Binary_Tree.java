import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class _08_Balanced_Binary_Tree {
    private class BTNode {
        public int value;
        public BTNode left;
        public BTNode right;

        public BTNode(int value) {
            this.value = value;
        }
    }

    private static class NodeDepthPair {
        BTNode node;
        int depth;

        NodeDepthPair(BTNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static boolean isBalanced(BTNode treeRoot) {
        // A tree with no nodes is superbalanced, since there are no leaves!
        if (treeRoot == null) {
            return true;
        }

        // We short-circuit as soon as we find more than 2
        List<Integer> depths = new ArrayList<>(3);

        // Nodes will store pairs of a node and the node's depth
        Stack<NodeDepthPair> nodes = new Stack<>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.empty()) {
            // Pop a node and its depth from the top of our stack
            NodeDepthPair nodeDepthPair = nodes.pop();
            BTNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            // Case: we found a leaf
            if (node.left == null && node.right == null) {
                // We only care if it's a new depth
                if (!depths.contains(depth)) {
                    depths.add(depth);

                    // Two ways we might now have an unbalanced tree:
                    //   1) more than 2 different leaf depths
                    //   2) 2 leaf depths that are more than 1 apart
                    if (depths.size() > 2 || (depths.size() == 2
                            && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }

                // Case: this isn't a leaf - keep stepping down
            } else {
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
    }
}