package DP;
import java.util.*;

public class NoOfLongestIncresingAuba {
    public int longestStrChain(String[] words) {
        Map<String, Integer> chains = new HashMap<>();  // Stores the max chain length for each word
        String[] sortedWords = Arrays.copyOf(words, words.length);
        Arrays.sort(sortedWords, (a, b) -> a.length() - b.length());  // Sort words by length

        for (String word : sortedWords) {
            chains.put(word, 1);  // Initialize the chain length for the current word

            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);  // Generate predecessor by removing one character
                if (chains.containsKey(pred)) {
                    chains.put(word, Math.max(chains.getOrDefault(word, 0), chains.get(pred) + 1));
                }
            }
        }

        int maxChainLength = chains.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        return maxChainLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        // Creating an object of Solution class
        NoOfLongestIncresingAuba sol = new NoOfLongestIncresingAuba();
//        int lengthOfLIS = sol.LIS(nums);
//
//        System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);
    }
}

