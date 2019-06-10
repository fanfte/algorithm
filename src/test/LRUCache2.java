package test;

import java.util.HashMap;

/**
 * Created by tianen on 2019/6/3
 *
 * @author fanfte
 * @date 2019/6/3
 **/
public class LRUCache2 {

    private HashMap<Integer, Node> map;

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;

    private Node tail;

    private int capacity;

    private int count;

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        count = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int value = node.value;
            deleteNode(node);
            addToHead(node);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count ++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
