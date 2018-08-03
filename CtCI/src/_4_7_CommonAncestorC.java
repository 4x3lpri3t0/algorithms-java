import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _4_7_CommonAncestorC {
    public static class Result {
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode n, Boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }

    public static Result commonAncestorHelper(
            TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) {
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            // This is the common ancestor
            return new Result(root, true);
        } else if (root == p || root == q) {
            /* If we're currently at p or q, and we also found one of those
             * nodes in a subtree, then this is truly an ancestor and the
             * flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(10);
        TreeNode n7 = root.find(6);
        BTreePrinter.printNode(root);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        if (ancestor != null) {
            out.println(ancestor.data);
        } else {
            out.println("null");
        }
    }
}