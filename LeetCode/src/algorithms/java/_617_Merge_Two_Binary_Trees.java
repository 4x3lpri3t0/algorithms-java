// https://leetcode.com/problems/merge-two-binary-trees

public class _617_Merge_Two_Binary_Trees {

    // Binary Neode node
    private class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    public static Node mergeTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}