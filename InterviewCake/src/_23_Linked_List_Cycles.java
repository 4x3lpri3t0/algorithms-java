class _23_Linked_List_Cycles {
    private class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode firstNode) {
        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        // Until we hit the end of the list
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            // Case: fastRunner is about to "lap" slowRunner
            if (fastRunner == slowRunner) {
                return true;
            }
        }

        // Case: fastRunner hit the end of the list
        return false;
    }
    // O(n) time
    // O(1) space
}