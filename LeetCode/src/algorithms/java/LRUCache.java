import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache

class LRUCache {
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    int count;
    int capacity;
    Map<Integer, DLinkedNode> map;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>(capacity);
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            deleteNode(node);
            addNode(node);

            return node.value;
        }

        return -1;
    }

    public DLinkedNode popTail() {
        return tail.prev;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            deleteNode(node);
            node.value = value;
            map.put(key, node);
            addNode(node);
        } else {
            if (count < capacity) {
                count++;
            } else {
                DLinkedNode tail = popTail();
                map.remove(tail.key);
                deleteTail();
            }

            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            addNode(node);
            map.put(key, node);
        }
    }

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void deleteTail() {
        DLinkedNode last = tail.prev;
        deleteNode(last);
    }

    private void deleteNode(DLinkedNode node) {
        DLinkedNode post = node.next;
        DLinkedNode pre = node.prev;
        pre.next = post;
        post.prev = pre;
    }
}