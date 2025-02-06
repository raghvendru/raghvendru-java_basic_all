package Tries;
import java.util.*;
class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    Node get(char ch) {
        return links[ch - 'a'];
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    void setEnd() {
        flag = true;
    }

    // Checks if the current node is the end of a word
    boolean isEnd() {
        return flag;
    }
}
class Trie {
    // Root node of the Trie
    Node root;

    // Initializes the Trie
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean checkIfAllPrefixExists(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if (!node.isEnd()) {
                    // Prefix is incomplete, return false
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
public class LongestWordWithALlprefixes {
    public String completeString(List<String> nums) {
        Trie obj = new Trie();

        // Insert all words into the Trie
        for (String num : nums) {
            obj.insert(num);
        }

        String longest = ""; // Stores the longest valid word

        // Check each word to find the longest one where all prefixes exist
        for (String num : nums) {
            if (obj.checkIfAllPrefixExists(num)) {
                if (num.length() > longest.length()) {
                    longest = num;
                } else if (num.length() == longest.length() && num.compareTo(longest) < 0) {
                    longest = num; // Lexicographically smaller word
                }
            }
        }
        return longest.isEmpty() ? "None" : longest; // Return result or "None"
    }

    public static void main(String[] args) {
        // Hardcoded test cases
        List<String> testCase1 = Arrays.asList("n", "ni", "nin", "ninj" , "ninja" , "nil");


        // Creating a solution instance
        LongestWordWithALlprefixes sol = new LongestWordWithALlprefixes();

        // Running test cases
        System.out.println("Test Case 1: " + sol.completeString(testCase1)); // Expected: "ninja"

    }
}

