package Trees;

import java.util.*;

import static java.lang.System.out;

public class InorderSuccessor {
    static Node findMin(Node root) {
        if (root == null)
            return null;

        while (root.left != null)
            root = root.left;

        return root;
    }

    static Node inorderSuccessorBst(Node root, int d) {
        if (root == null)
            return null;

        Node successor = null;

        while (root != null) {
            if (root.data < d) {
                root = root.right;
            } else if (root.data > d) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = findMin(root.right);
                }
                break;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        ArrayList<Integer> orig_data = new ArrayList<Integer>();
        orig_data.add(25);
        orig_data.add(125);
        orig_data.add(200);
        orig_data.add(350);
        orig_data.add(50);
        orig_data.add(75);
        orig_data.add(100);
        Node root = BinaryTree.createBST(orig_data);

        List<Integer> allData = BinaryTree.bstToArrayList(root);

        for (Integer d : orig_data) {
            Node successor = inorderSuccessorBst(root, d);
            int i = allData.indexOf(d);
            Integer expectedVal = null;
            if (i < allData.size() - 1) {
                expectedVal = allData.get(i + 1);
            }

            if (successor != null) {
                if (expectedVal != successor.data) {
                    out.println("*******" + d + " ==== " + expectedVal + ", " + successor.data + "*****");
                    //System.out.println(expected_val.intValue() == successor.data);
                }
            } else {
                //System.out.println(successor == null);
            }

            if (successor != null) {
                out.print("(" + d + ", " + successor.data + ") ");
            } else {
                out.print("(" + d + ", null) ");
            }
        }
    }
}