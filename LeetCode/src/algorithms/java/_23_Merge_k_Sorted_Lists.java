import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists

class _23_Merge_k_Sorted_Lists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        // Create PQ and pass comparator
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.size(), (o1, o2) -> {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val == o2.val)
                return 0;
            else
                return 1;
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;

            if (tail.next != null) {
                q.add(tail.next);
            }
        }

        return dummy.next;
    }
}