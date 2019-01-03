package LinkedLists;

import java.util.*;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/160003
public class RemoveDuplicates {
    static Node removeDuplicates(Node head) {
        if (head == null)
            return head;

        // Track values in set
        HashSet<Integer> dupSet = new HashSet<>();
        Node cur = head;
        dupSet.add(cur.data);

        while (cur.next != null) {
            if (dupSet.contains(cur.next.data)) {
                // Remove next
                cur.next = cur.next.next;
            } else {
                dupSet.add(cur.next.data);
            }
        }

        return head;
    }
}