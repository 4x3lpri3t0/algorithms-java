package LinkedLists;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/70003
public class ReverseSLL {
    public static Node reverseIterative(Node head) {
        if (head == null || head.next == null)
            return head;

        Node pendingNodes = head.next;
        Node reversedList = head;

        while (pendingNodes != null) {
            Node temp = pendingNodes;
            pendingNodes = pendingNodes.next;

            temp.next = reversedList;
            reversedList = temp;
        }

        return reversedList;
    }

    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null)
            return head;

        Node reversedList = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return reversedList;
    }
}