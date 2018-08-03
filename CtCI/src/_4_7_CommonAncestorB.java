import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _4_7_CommonAncestorB {
    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        if (root == p)
            return true;

        return covers(root.left, p) || covers(root.right, p);
    }

    public static TreeNode commonAncestorHelper(
            TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        boolean isPOnLeft = covers(root.left, p);
        boolean isQOnLeft = covers(root.left, q);
        if (isPOnLeft != isQOnLeft) {
            // Nodes are on different sides
            return root;
        }

        TreeNode childSide = isPOnLeft ? root.left : root.right;

        return commonAncestorHelper(childSide, p, q);
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            // Error check - one node is not in tree
            return null;
        }

        return commonAncestorHelper(root, p, q);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(1);
        TreeNode n7 = root.find(7);
        BTreePrinter.printNode(root);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        out.println(ancestor.data);
    }
}