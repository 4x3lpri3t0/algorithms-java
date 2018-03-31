import java.util.Stack;

class _09_BST_Checker {
    private class BTNode {
        int value;
        BTNode left;
        BTNode right;

        public BTNode(int value) {
            this.value = value;
        }
    }

    private static class NodeBounds {
        BTNode node;
        int lowerBound;
        int upperBound;

        NodeBounds(BTNode node, int lowerBound, int upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public static boolean isBinarySearchTree(BTNode root) {
        // Start at the root, with an arbitrarily low lower bound
        // and an arbitrarily high upper bound
        Stack<NodeBounds> nodeAndBoundsStack = new Stack<>();
        nodeAndBoundsStack.push(
                new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        // Depth-first traversal
        while (!nodeAndBoundsStack.empty()) {
            NodeBounds nb = nodeAndBoundsStack.pop();
            BTNode node = nb.node;
            int lowerBound = nb.lowerBound;
            int upperBound = nb.upperBound;

            // Node is invalid -> return false
            if (node.value <= lowerBound || node.value >= upperBound) {
                return false;
            }

            if (node.left != null) {
                // This node must be less than the current node
                nodeAndBoundsStack.push(
                        new NodeBounds(node.left, lowerBound, node.value));
            }
            if (node.right != null) {
                // This node must be greater than the current node
                nodeAndBoundsStack.push(
                        new NodeBounds(node.right, node.value, upperBound));
            }
        }

        // If none of the nodes were invalid, return true
        // (at this point we have checked all nodes)
        return true;
    }
}
// O(n) time
// O(n) space