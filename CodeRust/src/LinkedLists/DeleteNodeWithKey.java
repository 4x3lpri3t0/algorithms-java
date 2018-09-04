package LinkedLists;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class DeleteNodeWithKey {
    static Node deleteNode(Node head, int key) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (current.data == key) {

                if (current == head) {
                    head = head.next;
                    current = head;
                } else {
                    prev.next = current.next;
                    current = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}