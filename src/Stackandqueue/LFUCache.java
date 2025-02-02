package Stackandqueue;
import java.util.*;
class Node6 {
    int key, value, cnt;
    Node6 next;
    Node6 prev;
    Node6(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1;
    }
}
class List {
    int size; // Size 
    Node6 head; // Dummy head
    Node6 tail; // Dummy tail

    // Constructor
    List() {
        head = new Node6(0, 0);
        tail = new Node6(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    // Function to add Node6 in front
    void addFront(Node6 Node6) {
        Node6 temp = head.next;
        Node6.next = temp;
        Node6.prev = head;
        head.next = Node6;
        temp.prev = Node6;
        size++;
    }
    void removeNode6(Node6 delNode6) {
        Node6 prevNode6 = delNode6.prev;
        Node6 nextNode6 = delNode6.next;
        prevNode6.next = nextNode6;
        nextNode6.prev = prevNode6;
        size--;
    }
}
public class LFUCache {
    private Map<Integer, Node6> keyNode6;
    private Map<Integer, List> freqListMap;
    private int maxSizeCache; // Max size of cache
    private int minFreq;
    private int curSize;
    public LFUCache(int capacity) {
        // Set the capacity
        maxSizeCache = capacity;
        minFreq = 0; // Set minimum frequency
        curSize = 0; // Set current frequency
        keyNode6 = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    // Method to update frequency of data-items
    private void updateFreqListMap(Node6 Node6) {
        // Remove from Hashmap
        keyNode6.remove(Node6.key);

        // Update the frequency list hashmap
        freqListMap.get(Node6.cnt).removeNode6(Node6);

        // If Node6 was the last Node6 having its frequency
        if (Node6.cnt == minFreq &&
                freqListMap.get(Node6.cnt).size == 0) {
            // Update the minimum frequency
            minFreq++;
        }

        // Creating a dummy list for next higher frequency
        List nextHigherFreqList = new List();

        // If the next higher frequency list already exists
        if (freqListMap.containsKey(Node6.cnt + 1)) {
            // Update pointer to already existing list
            nextHigherFreqList =
                    freqListMap.get(Node6.cnt + 1);
        }

        // Increment the count of data-item
        Node6.cnt += 1;

        // Add the Node6 in front of higher frequency list
        nextHigherFreqList.addFront(Node6);

        // Update the frequency list map
        freqListMap.put(Node6.cnt, nextHigherFreqList);
        keyNode6.put(Node6.key, Node6);
    }

    // Method to get the value of key from LFU cache
    public int get(int key) {
        // Return the value if key exists
        if (keyNode6.containsKey(key)) {
            Node6 Node6 = keyNode6.get(key); // Get the Node6
            int val = Node6.value; // Get the value
            updateFreqListMap(Node6); // Update the frequency
            // Return the value
            return val;
        }
        // Return -1 if key is not found
        return -1;
    }

    public void put(int key, int value) {
       /* If the size of Cache is 0,
       no data-items can be inserted */
        if (maxSizeCache == 0) {
            return;
        }

        // If key already exists
        if (keyNode6.containsKey(key)) {
            // Get the Node6
            Node6 Node6 = keyNode6.get(key);
            // Update the value
            Node6.value = value;
            // Update the frequency
            updateFreqListMap(Node6);
        } else {
            // If cache limit is reached
            if (curSize == maxSizeCache) {
                // Remove the least frequently used data-item
                List list = freqListMap.get(minFreq);
                keyNode6.remove(list.tail.prev.key);

                // Update the frequency map
                freqListMap.get(minFreq).removeNode6(list.tail.prev);
                // Decrement the current size of cache
                curSize--;
            }
            // Increment the current cache size
            curSize++;

            // Adding new value to the cache
            minFreq = 1; // Set its frequency to 1

            // Create a dummy list
            List listFreq = new List();

            // If the list already exists
            if (freqListMap.containsKey(minFreq)) {
                // Update the pointer to already present list
                listFreq = freqListMap.get(minFreq);
            }

            // Create the Node6 to store data-item
            Node6 Node6 = new Node6(key, value);

            // Add the Node6 to dummy list
            listFreq.addFront(Node6);

            // Add the Node6 to Hashmap
            keyNode6.put(key, Node6);

            // Update the frequency list map
            freqListMap.put(minFreq, listFreq);
        }
    }
    public static void main(String[] args) {
        // LFU Cache
        LFUCache cache = new LFUCache(2);
        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        System.out.print(cache.get(3) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }
}
