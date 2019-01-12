package LinkedLists;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/180003
public class ReverseEvenNodes {
    // Two passes:

    // 1st: Create new LL and store all EVEN nodes in reverse order
    // (Insert at front)

    // 2nd: Go through the original LL and if current node is EVEN
    // -> Replace it for current node in even LL
    // -> Advance one node in even LL

    public static Node reverse_even_nodes(Node original) {
        Node head = original;
        Node evensLL = head;

        while (head != null) {
            if (head.data % 2 == 0) {
                Node newNode = new Node(head.data);
                newNode.next = evensLL;
                evensLL = newNode;
            }

            head = head.next;
        }

        head = original;

        while (head != null) {
            if (head.data % 2 == 0) {
                head.data = evensLL.data;

                evensLL = evensLL.next;
            }

            head = head.next;
        }

        return original;
    }
}
