package LinkedLists;

import java.util.*;

public class RemoveDuplicates {
    static Node removeDuplicates(Node head) {
        if (head == null)
            return head;

        // Track values in set
        HashSet<Integer> dupSet = new HashSet<>();
        Node cur = head;
        dupSet.add(cur.data);

        while (cur.next != null) {
            if (!dupSet.contains(cur.next.data)) {
                dupSet.add(cur.next.data);
            } else {
                // Remove next
                cur.next = cur.next.next;
            }
        }

        return head;
    }
}