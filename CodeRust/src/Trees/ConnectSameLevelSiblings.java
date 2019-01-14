package Trees;

import java.util.ArrayList;
import java.util.List;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/250002

// TC: O(n)
// MC: O(1)
public class ConnectSameLevelSiblings {
    private class Node {
        Node left;
        Node right;
        int data;
        Node next; // Sibling

        Node(int val) {
            this.data = val;
        }
    }

    private static Node connectNextLevel(Node head) {
        Node current = head;
        Node nextLevelHead = null;
        Node prev = null;

        while (current != null) {
            if (current.left != null && current.right != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.left;
                }

                current.left.next = current.right;

                if (prev != null) {
                    prev.next = current.left;
                }

                prev = current.right;
            } else if (current.left != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.left;
                }

                if (prev != null) {
                    prev.next = current.left;
                }

                prev = current.left;
            } else if (current.right != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.right;
                }

                if (prev != null) {
                    prev.next = current.right;
                }

                prev = current.right;
            }

            current = current.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return nextLevelHead;
    }

    public static void populateSiblingPointers(Node root) {
        if (root == null) {
            return;
        }

        root.next = null;

        do {
            root = connectNextLevel(root);
        } while (root != null);
    }

    static List<Integer> getLevelOrderUsingNext(Node root) {
        List<Integer> output = new ArrayList<>();
        while (root != null) {
            Node head = root;
            Node nextHead = null;
            while (head != null) {
                output.add(head.data);

                if (nextHead == null) {
                    nextHead = head.left != null ? head.left : head.right;
                }

                head = head.next;
            }
            root = nextHead;
        }
        return output;
    }
}