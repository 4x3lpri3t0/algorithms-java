package LinkedLists;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/160004
public class MergeTwoSortedLL {
    public static Node mergeSorted(Node head1, Node head2) {
        // if one of the lists is empty then the other one is the merged list
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node mergedHead = null;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        Node mergedTail = mergedHead;
        while (head1 != null && head2 != null) {
            Node temp = null;
            if (head1.data <= head2.data) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            mergedTail.next = temp;
            mergedTail = mergedTail.next;
        }

        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }

        return mergedHead;
    }
}