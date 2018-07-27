import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _4_8_IsSubtree {
    static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true; // The empty tree is a subtree of every tree.
        } else {
            return subTree(t1, t2);
        }
    }

    /* Checks if the binary tree rooted at r1 contains the binary tree
     * rooted at r2 as a subtree somewhere within it.
     */
    public static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null)
            return false; // Big tree empty & subtree still not found.
        if (r1.data == r2.data) {
            if (matchTree(r1, r2))
                return true;
        }

        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    /* Checks if the binary tree rooted at r1 contains the
     * binary tree rooted at r2 as a subtree starting at r1.
     */
    static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r2 == null && r1 == null)
            return true; // Nothing left in the subtree
        if (r2 == null || r1 == null)
            return false; // Big tree empty & subtree still not found
        if (r1.data != r2.data)
            return false;

        return (matchTree(r1.left, r2.left) &&
                    matchTree(r1.right, r2.right));
    }

    public static void main(String[] args) {
        // t2 is a subtree of t1
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] array2 = {2, 4, 5, 8, 9, 10, 11};

        TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

        if (containsTree(t1, t2))
            out.println("t2 is a subtree of t1");
        else
            out.println("t2 is not a subtree of t1");

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

        if (containsTree(t3, t4))
            out.println("t4 is a subtree of t3");
        else
            out.println("t4 is not a subtree of t3");
    }
}