package LinkedLists;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/70004
public class NthFromLastNode {
    public static Node find_nth_from_last(
            Node head,
            int n) {
        if (head == null || n < 1) {
            return null;
        }

        // We will use two pointers head and tail
        // where head and tail are 'n' nodes apart.
        Node tail = head;

        while (tail != null && n > 0) {
            tail = tail.next;
            --n;
        }

        // Check out-of-bounds
        if (n != 0) {
            return null;
        }

        // When tail pointer reaches the end of
        // list, head is pointing at nth node.
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }

        return head;
    }
}
