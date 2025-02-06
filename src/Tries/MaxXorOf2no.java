package Tries;
import java.util.*;
class Node2 {
    Node2[] links = new Node2[2];

    // To check if a specific bit key is present in the child Node2s
    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    // To get the child Node2 corresponding to a specific bit
    Node2 get(int bit) {
        return links[bit];
    }

    // To set a child Node2 at a specific index in the links array
    void put(int bit, Node2 Node2) {
        links[bit] = Node2;
    }
}

// Trie2 class
class Trie2 {
    private Node2 root;

    // Constructor
    Trie2() {
        root = new Node2();
    }

    // To insert number in Trie2
    void insert(int num) {
        // Start from the root
        Node2 Node2 = root;
        // Iterate each bit
        for (int i = 31; i >= 0; i--) {
            // Extract i-th bit
            int bit = (num >> i) & 1;
            /* If the current Node2 doesn't 
           have a child Node2 with the 
           current bit */
            if (!Node2.containsKey(bit)) {
                Node2.put(bit, new Node2());
            }
            Node2 = Node2.get(bit);
        }
    }

    // Method to find the maximum XOR 
    int getMax(int num) {
        // Start from root
        Node2 Node2 = root;
        // Initialize maximum XOR value
        int maxNum = 0;
        // Iterate each bit
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th bit 
            int bit = (num >> i) & 1;
            /*If the complement of the current bit 
            exists in the Trie2 update the maximum 
            XOR value with the current bit
            move to the child Node2 corresponding to 
            the complement of the current bit
            Else move to the child Node2 
            corresponding to the current bit */
            if (Node2.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                Node2 = Node2.get(1 - bit);
            } else {
                Node2 = Node2.get(bit);
            }
        }
        // Return maximum XOR
        return maxNum;
    }
}
public class MaxXorOf2no {
    public int findMaximumXOR(int[] nums) {
        // Create Trie2
        Trie2 Trie2 = new Trie2();
        // Insert number
        for (int num : nums) {
            Trie2.insert(num);
        }

        // Maximum XOR value
        int maxi = 0;

        // Iterate each number
        for (int num : nums) {
            // Update the maximum XOR
            maxi = Math.max(maxi, Trie2.getMax(num));
        }

        // Return maximum XOR value
        return maxi;
    }
    public static void main(String[] args) {
        MaxXorOf2no solution = new MaxXorOf2no();

        // Test case
        int[] nums = {3, 10, 5, 25, 2, 8};

        // Print the input array
        System.out.print("Input: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and print the maximum XOR value
        int result = solution.findMaximumXOR(nums);
        System.out.println("Maximum XOR value: " + result);
    }
}

