package LinkedLists;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class InsertionSort {
    public static Node insertionSort(Node head) {
        Node sorted = null;

        while (head != null) {
            Node temp = head.next;
            sorted = sortedInsert(sorted, head);
            head = temp;
        }

        return sorted;
    }

    private static Node sortedInsert(Node head, Node node) {
        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        Node cur = head;

        while (cur.next != null && cur.next.data < node.data) {
            cur = cur.next;
        }

        node.next = cur.next;
        cur.next = node;

        return head;
    }
}