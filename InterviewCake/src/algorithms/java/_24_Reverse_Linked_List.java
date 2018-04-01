class _24_Reverse_Linked_List {
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverse(Node headOfList) {
        Node currentNode = headOfList;
        Node previousNode = null;
        Node nextNode = null;

        // Until we have 'fallen off' the end of the list
        while (currentNode != null) {

            // Copy a pointer to the next element
            // before we overwrite currentNode.next
            nextNode = currentNode.next;

            // Reverse the 'next' pointer
            currentNode.next = previousNode;

            // Step forward in the list
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }
    // O(n) time
    // O(1) space
}