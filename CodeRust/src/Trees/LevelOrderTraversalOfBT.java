package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/170003
public class LevelOrderTraversalOfBT {
    public static void levelOrderTraversal(Node root) {
        // Using two queues: current_queue and next_queue.
        // We push nodes in both queues alternately based on the current level number.

        ArrayList<Queue<Node>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<>());
        queues.add(new ArrayDeque<>());

        Queue<Node> currentQueue = queues.get(0);
        Queue<Node> nextQueue = queues.get(1);

        currentQueue.add(root);
        int level = 0;

        while (!currentQueue.isEmpty()) {
            Node temp = currentQueue.poll();
            out.print(temp.data + ",");

            if (temp.left != null) {
                nextQueue.add(temp.left);
            }

            if (temp.right != null) {
                nextQueue.add(temp.right);
            }

            if (currentQueue.isEmpty()) {
                out.println();
                ++level;
                currentQueue = queues.get(level % 2);
                nextQueue = queues.get((level + 1) % 2);
            }
        }
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

        levelOrderTraversal(root);
    }
}
