package Trees;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ConvertBinaryTreeToDoublyLL {
    // Merge two sorted linked lists
    static Node concatenateLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // Use left for previous and right for next.
        Node tail1 = head1.left;
        Node tail2 = head2.left;

        tail1.right = head2;
        head2.left = tail1;

        head1.left = tail2;
        tail2.right = head1;

        return head1;
    }


    public static Node convertToLinkedList(Node root) {
        if (root == null) {
            return null;
        }

        Node list1 = convertToLinkedList(root.left);
        Node list2 = convertToLinkedList(root.right);

        root.left = root.right = root;
        Node result = concatenateLists(list1, root);
        result = concatenateLists(result, list2);

        return result;
    }

    static List<Integer> getList(Node head) {
        List<Integer> r = new ArrayList<>();
        if (head == null) {
            return r;
        }

        Node temp = head;
        do {
            r.add(temp.data);
            temp = temp.right;
        } while (temp != head);

        return r;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(125);
        input.add(350);
        input.add(30);
        input.add(60);
        Node root = BinaryTree.createBST(input);
        Node head = convertToLinkedList(root);
        List<Integer> result = getList(head);
        out.println(result);
    }
}
