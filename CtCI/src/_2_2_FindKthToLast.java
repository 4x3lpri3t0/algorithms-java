import static java.lang.System.out;

public class _2_2_FindKthToLast {
    public static LLNode kthToLast(LLNode head, int k) {
        // Use the k as a stick that moves the head and the tail
        LLNode tail = head;

        // First while k-- > 0, move tail
        while (k-- > 0) {
            tail = tail.next;
            if (tail == null)
                return null; // Input was invalid (list shorter than k)
        }

        // While tail != null -> keep moving both
        // Tail hits the end -> Head will be at the right element
        while (tail != null) {
            head = head.next;
            tail = tail.next;
        }

        return head;
    }

    // TC: O(n)
    // SC: O(1)

    public static void main() {
        LLNode head = new LLNode(10);
        head.appendToTail(9);
        head.appendToTail(8);
        head.appendToTail(7);
        head.appendToTail(6);
        head.appendToTail(5);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);
        out.println(kthToLast(head, 5).data);
        out.println(kthToLast(head, 1).data);
    }
}