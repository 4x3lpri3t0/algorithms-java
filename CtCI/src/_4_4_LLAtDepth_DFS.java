import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _4_4_LLAtDepth_DFS {
    public static void createLevelLinkedList(
            TreeNode root,
            ArrayList<LinkedList<TreeNode>> lists,
            int level) {

        if (root == null)
            return;

        LinkedList<TreeNode> list;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<>();

            /* Levels are always traversed in order.
            So, if this is the first time we've visited level i,
            we must have seen levels 0 through i - 1.
            We can therefore safely add the level at the end. */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(
            TreeNode root) {

        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);

        return lists;
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            out.print("Link list at depth " + depth + ":");

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