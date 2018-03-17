
// https://leetcode.com/problems/add-two-numbers/

public class _2_Add_Two_Numbers {

    // Definition for singly-linked list
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (p != null || q != null || carry > 0) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        return head.next;
    }
}

// Time complexity : O(max(m,n)). Assume that m and n represents the length of
// l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
//
// Space complexity : O(max(m,n)).
// The length of the new list is at most max(m,n) + 1.
