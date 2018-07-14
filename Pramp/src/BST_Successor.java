/*
# BST Successor Search

Given a node n in a BST, explain and code the most efficient way to find the successor of n.

Analyze the runtime complexity of your solution.
*/

public class BST_Successor {
    private class Node {
        int data;
        Node left, right, parent;

        Node(int d) {
            data = d;
            left = right = parent = null;
        }
    }

    static Node head;

    /* Given a binary search tree and a number,
    inserts a new node with the given number in
    the correct place in the tree. Returns the new
    root pointer which the caller should then use.*/
    Node insert(Node node, int data) {

        // 1. If the tree is empty, return a new, single node
        if (node == null) {
            return (new Node(data));
        } else {

            Node temp = null;

            // 2. Otherwise, traverse down the tree
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;

            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            // Return the (unchanged) node pointer
            return node;
        }
    }

    Node inOrderSuccessor(Node root, Node n) {
        // Step 1 of the above algorithm
        if (n.right != null) {
            return minValue(n.right);
        }

        // Step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }

        return p;
    }

    // Given a non-empty BST, return the minimum data value found in that tree.
    // Note that the entire tree does not need to be searched.
    Node minValue(Node node) {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public static void main(String[] args) {
        // Binary Tree
        BST_Successor tree = new BST_Successor();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}
