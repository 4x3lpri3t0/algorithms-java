package LinkedLists;

public class IntersectionPointOfTwoLists {
    public static Node intersect(Node head1, Node head2) {

        // Find lengths of both LL
        Node list1node = null;
        int list1length = getLength(head1);
        Node list2node = null;
        int list2length = getLength(head2);

        // Calculate diff of both LL: d = |L1 - L2|
        int lengthDifference = 0;
        if (list1length >= list2length) {
            lengthDifference = list1length - list2length;
            list1node = head1;
            list2node = head2;
        } else {
            lengthDifference = list2length - list1length;
            list1node = head2;
            list2node = head1;
        }


        while (lengthDifference > 0) {
            list1node = list1node.next;
            lengthDifference--;
        }

        while (list1node != null) {
            if (list1node == list2node) {
                return list1node;
            }

            list1node = list1node.next;
            list2node = list2node.next;
        }

        return null;
    }

    private static int getLength(Node head) {
        int listLength = 0;

        while (head != null) {
            head = head.next;
            listLength++;
        }

        return listLength;
    }
}
