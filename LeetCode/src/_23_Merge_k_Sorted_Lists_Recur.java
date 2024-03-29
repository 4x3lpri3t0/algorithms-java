// https://leetcode.com/problems/merge-k-sorted-lists

class _23_Merge_k_Sorted_Lists_Recur {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private static ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }

        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);

            return merge(l1, l2);
        } else {
            return null;
        }
    }

    //This function is from Merge Two Sorted Lists.
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);

            return l1;
        } else {
            l2.next = merge(l1, l2.next);

            return l2;
        }
    }
}