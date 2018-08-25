package Trees;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.System.out;

public class InorderIterator {
    public class InorderTreeIterator {
        Stack<Node> stk = new Stack<>();

        public InorderTreeIterator(Node root) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public Node getNext() {
            Node rVal = stk.pop();
            Node temp = rVal.right;
            while (temp != null) {
                stk.push(temp);
                temp = temp.left;
            }

            return rVal;
        }
    }

    public void inorderUsingIterator(Node root) {
        InorderTreeIterator iter = new InorderTreeIterator(root);
        while (iter.hasNext()) {
            out.print(iter.getNext().data + ", ");
        }

        out.println();
    }

    public static void main(String[] args) {
        InorderIterator instance = new InorderIterator();

        ArrayList<Integer> input = new ArrayList<>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(26);
        input.add(75);
        input.add(125);
        input.add(350);
        Node root = BinaryTree.createBST(input);

        instance.inorderUsingIterator(root);
        out.println();
    }
}
