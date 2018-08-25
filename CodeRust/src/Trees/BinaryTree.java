package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class BinaryTree {
    private static void insertBST(Node root, int n) {
        while (true) {
            if (n < root.data) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new Node(n);
                    break;
                }
            } else if (n > root.data) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new Node(n);
                    break;
                }
            } else {
                // Identical. Not doing anything in this case.
            }
        }
    }

    public static Node createBST(ArrayList<Integer> list) {
        Node root = new Node(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            insertBST(root, list.get(i));
        }

        return root;
    }

    public static void displayLevelOrder(Node root) {
        // Base case
        if (root == null)
            return;

        // Create an empty queue for lvl order traversal
        Queue<Node> q = new LinkedList<>();

        // Enqueue root and initialize height
        q.add(root);

        while (true) {
            // Indicates number of nodes at current lvl
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            // Dequeue all nodes of current lvl and
            // Enqueue all nodes of next lvl
            while (nodeCount > 0) {
                Node node = q.poll();
                out.print(node.data + " ");

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

                nodeCount--;
            }

            out.println();
        }
    }

    public static void displayInorder(Node node) {
        if (node == null) {
            return;
        }

        displayInorder(node.left);
        out.println(node.data);
        displayInorder(node.right);
    }
}