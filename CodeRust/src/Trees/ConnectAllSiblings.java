package Trees;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/270001

// TC: O(n)
// MC: O(1)
public class ConnectAllSiblings {
    public static void populateSiblingPointers(Node root) {
        if (root == null)
            return;

        Node current = root;
        Node last = root;

        while (current != null) {
            if (current.left != null) {
                last.next = current.left;
                last = current.left;
            }

            if (current.right != null) {
                last.next = current.right;
                last = current.right;
            }

            last.next = null;
            current = current.next;
        }
    }
}