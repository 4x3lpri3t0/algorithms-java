import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _4_4_LLAtDepth_BFS {
    static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        // Visit the root
        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null)
            current.add(root);

        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                // Visit children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }

    static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> treeNodes : result) {
            Iterator<TreeNode> i = treeNodes.listIterator();

            out.println("Link list at depth " + depth + ":");
            while (i.hasNext()) {
                out.print(" " + i.next().data);
            }

            out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }
}