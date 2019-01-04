package LinkedLists;

public class SwapNthNodeWithHead {
    static Node swap_nth_node(Node head, int n) {
        Node prev = null;
        Node current = head;

        if (head == null || n == 1) {
            return head;
        }

        for (int count = 1; current != null && count < n; ++count) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return head;
        }

        // current is pointing to nth node.
        // Let's swap nth node with head.

        prev.next = head;
        Node temp = head.next;
        head.next = current.next;
        current.next = temp;

        return current;
    }
}
