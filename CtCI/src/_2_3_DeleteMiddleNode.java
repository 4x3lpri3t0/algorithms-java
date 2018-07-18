import java.io.*;
import java.util.*;

public class _2_3_DeleteMiddleNode {
    private static LLNode delete(LLNode nodeToDelete) {
        if (nodeToDelete.next == null) {
            return null; // Invalid
        }

        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;

        return nodeToDelete;
    }

    public static void main() {
        LLNode head = new LLNode(1);
        head.appendToTail(2);
        head.appendToTail(3);
        delete(head.next); // Delete 2

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}