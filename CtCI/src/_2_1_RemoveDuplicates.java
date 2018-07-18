public class _2_1_RemoveDuplicates {
    private static void removeDuplicates(LLNode head) {
        LLNode cur = head;

        while (cur != null) {
            LLNode runner = cur;

            while (runner.next != null) {
                if (cur.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            cur = cur.next;
        }
    }

    // TC: O(n2)
    // SC: O(1)

    // To make it faster we need a buffer
    // (HashSet in which we store the already seen)

    public static void main() {
        LLNode head = new LLNode(10);
        head.appendToTail(10);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(2);
        removeDuplicates(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}