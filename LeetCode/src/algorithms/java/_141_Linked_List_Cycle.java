import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle

class _141_Linked_List_Cycle {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle_hashSet(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }

            head = head.next;
        }

        return false;
    }

    public boolean hasCycle_2Pointers(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }
    // Space complexity: Reduced to O(1).
}
