import static java.lang.System.out;

public class _4_5_IsBinaryTree {
    public static Integer lastPrinted = Integer.MIN_VALUE;

    private static boolean checkBST(TreeNode n) {
        if (n == null) {
            return true;
        }

        // Check / recurse left
        if (n.left != null) {
            checkBST(n.left);
        }

        // Check current
        if (n.data <= lastPrinted) {
            return false;
        }

        lastPrinted = n.data;

        // Check / recurse right
        if (!checkBST(n.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(10);
        TreeNode r1Left = new TreeNode(9);
        TreeNode r1Right = new TreeNode(11);
        r1.setLeftChild(r1Left);
        r1.setRightChild(r1Right);
        r1Right.setRightChild(new TreeNode(12));
        r1Left.setLeftChild(new TreeNode(8));

        out.println(checkBST(r1)); // true

        TreeNode r2 = new TreeNode(50);
        r2.setLeftChild(new TreeNode(500));
        r2.setRightChild(new TreeNode(5000));

        out.println(checkBST(r2)); // false

        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 5;
        //node.left.right.data = 3;
        out.println(checkBST(node));
    }
}