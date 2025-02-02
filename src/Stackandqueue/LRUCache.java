package Stackandqueue;
import java.util.*;
class Node5 {
    public int key, val;
    public Node5 next, prev;
    Node5() {
        key = val = -1;
        next = prev = null;
    }
    Node5(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}
public class LRUCache {
    private Map<Integer, Node5> mpp; // Map data structure
    private int cap; // Capacity
    private Node5 head; // Dummy head pointer
    private Node5 tail; // Dummy tail pointer
    private void deleteNode5(Node5 Node5) {
        Node5 prevNode5 = Node5.prev;
        Node5 nextNode5 = Node5.next;
        prevNode5.next = nextNode5;
        nextNode5.prev = prevNode5;
    }
    private void insertAfterHead(Node5 Node5) {
        Node5 nextNode5 = head.next;
        head.next = Node5;
        nextNode5.prev = Node5;
        Node5.prev = head;
        Node5.next = nextNode5;
    }
    public LRUCache(int capacity) {
        cap = capacity; // Set the capacity
        mpp = new HashMap<>(); // Clear the cache
        head = new Node5();
        tail = new Node5();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key_) {
        if (!mpp.containsKey(key_))
            return -1;
        Node5 Node5 = mpp.get(key_); // Get the Node5
        int val = Node5.val; // Get the value
        deleteNode5(Node5);
        insertAfterHead(Node5);
        return val;
    }
    public void put(int key_, int value) {
        if (mpp.containsKey(key_)) {
            Node5 Node5 = mpp.get(key_); // Get the Node5
            Node5.val = value; // Update the value
            deleteNode5(Node5);
            insertAfterHead(Node5);
            return;
        }
        if (mpp.size() == cap) {
            Node5 Node5 = tail.prev;
            mpp.remove(Node5.key);
            deleteNode5(Node5);
        }
        Node5 newNode5 = new Node5(key_, value);
        mpp.put(key_, newNode5);
        insertAfterHead(newNode5);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }
}
