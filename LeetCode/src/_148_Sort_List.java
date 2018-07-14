// https://leetcode.com/problems/sort-list

public class _148_Sort_List {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode merge(ListNode h, ListNode m) {
        ListNode fake = new ListNode(0), cur = fake;

        while (h != null && m != null) {
            if (h.val < m.val) {
                cur.next = h;
                h = h.next;
            } else {
                cur.next = m;
                m = m.next;
            }
            cur = cur.next;
        }

        cur.next = (h == null ? m : h);

        return fake.next;
    }

    // Quicksort (h is head)
    ListNode quickSort(final ListNode h) {
        if (h == null || h.next == null)
            return h;

        // Split into three list
        ListNode fakeSmall = new ListNode(0), small = fakeSmall;
        ListNode fakeLarge = new ListNode(0), large = fakeLarge;
        ListNode fakeEqual = new ListNode(0), equal = fakeEqual;

        ListNode cur = h; // Pivot is h
        while (cur != null) {
            if (cur.val < h.val) {
                small.next = cur;
                small = small.next;
            } else if (cur.val == h.val) {
                equal.next = cur;
                equal = equal.next;
            } else {
                large.next = cur;
                large = large.next;
            }

            cur = cur.next;
        }

        // Put an end
        small.next = equal.next = large.next = null;

        // Merge them and return
        return merge(merge(quickSort(fakeSmall.next), quickSort(fakeLarge.next)), fakeEqual.next);
    }

    // Merge sort (Alt approach)
    ListNode mergeSort(ListNode h) {
        if (h == null || h.next == null)
            return h;

        // Find cutting point
        ListNode slow = h, cut = null, fast = h;
        while (fast != null && fast.next != null) {
            cut = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut
        cut.next = null;

        return merge(mergeSort(h), mergeSort(slow));
    }
}
