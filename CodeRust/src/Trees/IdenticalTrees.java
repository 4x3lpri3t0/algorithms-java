package Trees;

import java.util.ArrayList;

import static java.lang.System.out;

public class IdenticalTrees {
    public static boolean areIdentical(
            Node root1,
            Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return (root1.data == root2.data) &&
            areIdentical(root1.left, root2.left) &&
            areIdentical(root1.right, root2.right);
        }

        return false;
    }

    public static void main(String[] argv) {
        ArrayList<Integer> input1 = new ArrayList<>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        Node root = BinaryTree.createBST(input1);

        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(1);
        input2.add(2);
        input2.add(10);
        input2.add(50);
        input2.add(180);
        input2.add(199);
        Node root2 = BinaryTree.createBST(input2);

        BinaryTree.displayLevelOrder(root);
        out.println();

        BinaryTree.displayLevelOrder(root2);
        out.println();

        // All should print true
        out.println("same " + Boolean.toString(areIdentical(root, root)));
        out.println("null " + Boolean.toString(!areIdentical(root, null)));
        out.println("null,null " + Boolean.toString(areIdentical(null, null)));
        out.println("different " + Boolean.toString(!areIdentical(root, root2)));
    }
}