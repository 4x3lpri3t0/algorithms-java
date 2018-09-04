package LinkedLists;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class ReverseSLL {
    public static Node reverseIterative(Node head) {
        if (head == null || head.next == null)
            return head;

        Node listToDo = head.next;
        Node reversedList = head;

        while (listToDo != null) {
            Node temp = listToDo;
            listToDo = listToDo.next;

            temp.next = reversedList;
            reversedList = temp;
        }

        return reversedList;
    }

    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null)
            return head;

        Node reversedList = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return reversedList;
    }

    public static void main(String[] args) {

    }
}