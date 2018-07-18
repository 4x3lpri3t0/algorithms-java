public class LLNode {
    LLNode next = null;
    int data;

    public LLNode(int d) {
        data = d;
    }

    void appendToTail(int d) {
        LLNode end = new LLNode(d);
        LLNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}