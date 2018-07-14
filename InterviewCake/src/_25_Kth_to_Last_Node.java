class _25_Kth_to_Last_Node {
    private class LinkedListNode {
        String value;
        LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (k < 1) {
            throw new IllegalArgumentException();
        }

        LinkedListNode leftNode = head;
        LinkedListNode rightNode = head;

        // Move rightNode to the kth node
        for (int i = 0; i < k - 1; i++) {
            // If a rightNode doesn't have a next,
            // then k is greater than the length of the list
            if (rightNode.next == null) {
                throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
            }

            rightNode = rightNode.next;
        }

        // Starting with leftNode on the head,
        // move leftNode and rightNode down the list,
        // maintaining a distance of k between them,
        // until rightNode hits the end of the list
        while (rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        // Since leftNode is k nodes behind rightNode,
        // leftNode is now the kth to last node!
        return leftNode;
    }
    // O(n) time
    // O(1) space
}