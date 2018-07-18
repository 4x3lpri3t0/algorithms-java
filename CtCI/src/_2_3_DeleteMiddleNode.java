import static java.lang.System.out;

public class _2_3_DeleteMiddleNode {
    private static boolean tryDelete(LLNode nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            return false; // Failure (Invalid)
        }

        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;

        return true;
    }

    public static void main() {
        LLNode head = new LLNode(1);
        head.appendToTail(2);
        head.appendToTail(3);
        tryDelete(head.next); // Delete 2

        while (head != null) {
            out.println(head.data);
            head = head.next;
        }

        out.println(tryDelete(new LLNode(100))); // False
    }
}