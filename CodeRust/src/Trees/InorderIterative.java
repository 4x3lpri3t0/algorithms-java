package Trees;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.System.out;

public class InorderIterative {
    static String inorderIterative(Node root) {
        String result = "";
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
                continue;
            }

            result += stack.peek().data + ",";
            out.println(stack.peek().data + " ");
            root = stack.pop().right;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(125);
        input.add(350);
        Node root = BinaryTree.createBST(input);
        inorderIterative(root);
        out.println();
    }
}