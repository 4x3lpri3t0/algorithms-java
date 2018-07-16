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

    public static void main() {
        LLNode head = new LLNode(10);
        head.appendForTail(10);
        head.appendForTail(1);
        head.appendForTail(1);
        head.appendForTail(2);
        head.appendForTail(2);
        head.appendForTail(2);
        head.appendForTail(3);
        head.appendForTail(2);
        removeDuplicates(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}