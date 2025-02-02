package SlidingWindow;
import java.util.*;
public class LongestSubStringwithoutREap {
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();

        // Assuming all ASCII characters
        int HashLen = 256;

        /* Hash table to store last
           occurrence of each character */
        int[] hash = new int[HashLen];

        /* Initialize hash table with
           -1 (indicating no occurrence) */
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            /* If current character s.charAt(r)
               is already in the substring */
            if (hash[s.charAt(r)] != -1) {
                /* Move left pointer to the right
                   of the last occurrence of s.charAt(r) */
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }

            // Calculate the current substring length
            int len = r - l + 1;

            // Update maximum length found so far
            maxLen = Math.max(len, maxLen);

            /* Store the index of the current
               character in the hash table */
            hash[s.charAt(r)] = r;

            // Move right pointer to next position
            r++;
        }

        // Return the maximum length found
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "cadbzabcd";

        // Create an instance of the Solution class
        LongestSubStringwithoutREap sol = new LongestSubStringwithoutREap();

        int result = sol.longestNonRepeatingSubstring(s);

        // Output the maximum length
        System.out.println("The maximum length is:");
        System.out.println(result);
    }
}
