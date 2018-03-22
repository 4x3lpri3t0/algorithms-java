import java.util.LinkedList;
import java.util.Queue;

class _104_Maximum_Depth_of_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recusive solution
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Iterative + Q
    public int maxDepth_Iterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            count++;
        }

        return count;
    }
}