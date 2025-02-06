package Tries;
import java.util.*;

public class DistinctSubString {
    public int countDistinctSubstring(String s) {
        int count = 0;
        // Root node of the Trie
        Node root = new Node();

        // Iterate over all starting positions of substrings
        for (int i = 0; i < s.length(); i++) {
            Node node = root;

            // Iterate through characters of the substring starting at index i
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                // If the current character is not a child of the current node, insert it
                if (!node.containsKey(currentChar)) {
                    count++;
                    // Insert new child node for character s[j]
                    node.put(currentChar, new Node());
                }
                // Move to the child node
                node = node.get(currentChar);
            }
        }

        // Return the total count of distinct substrings including the empty string
        return count + 1;  // +1 to count the empty substring
    }

    public static void main(String[] args) {
        DistinctSubString solution = new DistinctSubString();
        String input = "abc";
        System.out.println("Number of distinct substrings: " + solution.countDistinctSubstring(input));
    }
}

