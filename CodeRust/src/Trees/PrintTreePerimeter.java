package Trees;

import java.util.Stack;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/10005
public class PrintTreePerimeter {
    static void printLeftPerimeter(Node root) {
        // While not a leaf node.
        while (root != null && !(root.left == null && root.right == null)) {
            out.print(root.data + " ");

            if (root.left != null) {
                root = root.left;
            } else { // Right node
                root = root.right;
            }
        }
    }

    static void printRightPerimeter(Node root) {
        // Stack for right side values.
        Stack<Integer> rValues = new Stack<>();

        // While not a leaf node.
        while (root != null && !(root.left == null && root.right == null)) {
            rValues.push(root.data);

            if (root.right != null) {
                root = root.right;
            } else { // Left node
                root = root.left;
            }
        }

        // From bottom to top
        while (!rValues.isEmpty()) {
            out.print(rValues.pop() + " ");
        }
    }

    static void printLeafNodes(Node root) {
        if (root == null)
            return;

        printLeafNodes(root.left);
        printLeafNodes(root.right);

        if (root.left == null && root.right == null) {
            out.print(root.data + " ");
        }
    }

    public static void displayTreePerimeter(Node root) {
        if (root == null)
            return;

        out.print(root.data + " ");

        // Left
        printLeftPerimeter(root.left);

        // Bottom
        if (root.left != null || root.right != null) {
            // We don't need to print if root is also the leaf node.
            printLeafNodes(root);
        }

        // Right
        printRightPerimeter(root.right);
    }
}
