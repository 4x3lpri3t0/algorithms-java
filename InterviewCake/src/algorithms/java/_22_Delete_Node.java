class _22_Delete_Node {
    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void deleteNode(Node nodeToDelete) {
        // Get the input node's next node, the one we want to skip to
        Node nextNode = nodeToDelete.next;

        if (nextNode != null) {
            // Previous node now skips over the input node
            nodeToDelete.value = nextNode.value;
            nodeToDelete.next = nextNode.next;
        } else {
            throw new IllegalArgumentException(
                    "Can't delete the last node with this technique!");
        }
    }
    // O(1) time
    // O(1) space
}