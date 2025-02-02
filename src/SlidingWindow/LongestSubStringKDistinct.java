package SlidingWindow;
import java.util.*;
public class LongestSubStringKDistinct {
    public int kDistinctChar(String s, int k) {

        /* Initialize left pointer, right pointer,
        and maximum length of substring*/
        int l = 0, r = 0, maxLen = 0;

        // Hash map to store character frequencies
        HashMap<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {
            // Increment frequency of current character
            char currentChar = s.charAt(r);
            mpp.put(currentChar, mpp.getOrDefault(currentChar, 0) + 1);


            /* If the number of distinct characters
            exceeds k, shrink the window from the left*/
            while (mpp.size() > k) {

                // Decrement frequency of character at left pointer
                char leftChar = s.charAt(l);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {

                     /* Remove character from map
                    if its frequency becomes zero*/
                    mpp.remove(leftChar);
                }
                // Move left pointer to the right
                l++;
            }

           /* Update maximum length of substring with
            at most k distinct characters found so far*/
            if (mpp.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            // Move right pointer
            r++;
        }

        // Return the maximum length found
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";

        //Create an instance of Solution class
        LongestSubStringKDistinct sol = new LongestSubStringKDistinct();

        int res = sol.kDistinctChar(s, 2);

        // Output the result
        System.out.println("The maximum length of substring with at most 2 distinct characters is: " + res);
    }
}

