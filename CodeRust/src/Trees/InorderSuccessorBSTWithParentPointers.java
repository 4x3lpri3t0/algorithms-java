package Trees;

import java.util.ArrayList;

public class InorderSuccessorBSTWithParentPointers {
    private class Node {
        Node parent;
        Node left;
        Node right;
        int data;
    }

    static Node findMinInTree(
            Node root) {

        if (root == null)
            return null;

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    static Node inorderSuccessorBSTParentPointer(Node node) {

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return findMinInTree(node.right);
        }

        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }
            node = node.parent;
        }

        return null;
    }

    static Node findSuccessor(
            Node root, int d) {
        while (root != null) {

            if (root.data < d) {
                root = root.right;
            } else if (root.data > d) {
                root = root.left;
            } else {
                return inorderSuccessorBSTParentPointer(root);
            }
        }
        return null;
    }
}