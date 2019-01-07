package Trees;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/290001
public class IsBinarySearchTree {
    public static boolean isBST(Node root) {
        boolean leftIsBST = true;
        boolean rightIsBST = true;

        if (root.left != null) {
            leftIsBST = root.left.data <= root.data && isBST(root.left);
        }

        if (root.right != null) {
            rightIsBST = root.right.data >= root.data && isBST(root.right);
        }

        return leftIsBST && rightIsBST;
    }

    public static void main(String[] args) {
        Node root = new Node(500);

        Node left = new Node(25);
        left.left = new Node(1);
        left.right = new Node(50);
        root.left = left;

        Node right = new Node(750);
        right.left = new Node(600);
        right.right = new Node(900);
        root.right = right;

        System.out.println(isBST(root));
    }
}
