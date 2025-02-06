package Tries;
import java.util.*;
import java.util.*;

// Node3 Structure for Trie3
class Node3 {
    Node3[] links = new Node3[2];


    boolean containsKey(int ind) {
        return links[ind] != null;
    }


    Node3 get(int ind) {
        return links[ind];
    }

    void put(int ind, Node3 Node3) {
        links[ind] = Node3;
    }
}

// Definition for Trie3 data structure
class Trie3 {
    private Node3 root;

    // Constructor
    Trie3() {
        root = new Node3();
    }

    // Function to insert a number into the Trie3
    void insert(int num) {
        // Start traversal
        Node3 Node3 = root;

        /* Traverse each bit of the number 
           from the most significant bit to the 
           least significant bit */
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            /* If the current Node3 doesn't have 
               a child Node3 at the current bit, 
               create one */
            if (!Node3.containsKey(bit)) {
                Node3.put(bit, new Node3());
            }

            /* Move to the child Node3
               corresponding to the 
               current bit */
            Node3 = Node3.get(bit);
        }
    }

    // Function to find maximum XOR
    int findMax(int num) {
        Node3 Node3 = root;
        int maxNum = 0;

        /* Traverse each bit of the number from 
           the most significant bit to the least 
           significant bit extract the i-th 
           bit of the number.
           If there exists a different bit 
           in the Trie3 at the current 
           position, choose it to maximize XOR */
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (Node3.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                Node3 = Node3.get(1 - bit);
            } else {
                Node3 = Node3.get(bit);
            }
        }

        // Return maximum XOR value
        return maxNum;
    }
}

public class MaxXORwithAnElement {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        // Initialize array to store results of queries
        int[] ans = new int[queries.length];

        // List to store offline queries
        List<int[]> offlineQueries = new ArrayList<>();

        // Sort the array of numbers
        Arrays.sort(nums);

        // Convert queries to offline queries and store them in a list
        for (int i = 0; i < queries.length; i++) {
            offlineQueries.add(new int[]{queries[i][1], queries[i][0], i});
        }

        // Sort queries based on their end points
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        int i = 0;
        Trie3 Trie3 = new Trie3();

        // Process each query
        for (int[] query : offlineQueries) {
            // Insert numbers
            while (i < nums.length && nums[i] <= query[0]) {
                Trie3.insert(nums[i]);
                i++;
            }

            /* If there are numbers inserted into the Trie3,
               find the maximum XOR value for the query range */
            if (i != 0)
                ans[query[2]] = Trie3.findMax(query[1]);
            else
                ans[query[2]] = -1;
        }

        // Return results
        return ans;
    }

    public static void main(String[] args) {
        // Create instance of Solution class
        MaxXORwithAnElement sol = new MaxXORwithAnElement();

        // Input array of numbers
        int[] nums = {0, 1, 2, 3, 4};

        // Queries in the form of [x, m]
        int[][] queries = {{3, 1}, {1, 3}, {5, 6}};

        // Get the results of the maximize XOR queries
        int[] result = sol.maximizeXor(nums, queries);

        // Output the results
        System.out.println("Result of Max XOR Queries:");
        for (int i = 0; i < result.length; ++i) {
            System.out.println("Query " + (i + 1) + ": " + result[i]);
        }
    }
}

