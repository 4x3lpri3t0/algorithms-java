class _10_Second_Largest_Item_in_BST {
    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    private static int findLargest(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }

        return current.value;
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null
                && rootNode.right == null)) {
            throw new IllegalArgumentException("At least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {
            // Case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }

            // Case: current is parent of largest, and largest has no children,
            // so current is 2nd largest
            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }
}
// O(h) time -> h is the height of the tree (that's O(lg n)
// if the tree is balanced, O(n) otherwise).
// O(1) space