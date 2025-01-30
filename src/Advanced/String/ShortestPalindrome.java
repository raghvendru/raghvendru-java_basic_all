package Advanced.String;
import java.util.*;
public class ShortestPalindrome {
        private int[] computeLPS(String s) {
            int n = s.length(); // size of string
            // To store the longest prefix suffix
            int[] LPS = new int[n];
            // Iterate on the string
            for (int i = 1; i < n; i++) {
                // for all possible lengths
                for (int len = 1; len < i; len++) {
                    if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                        LPS[i] = len;
                    }
                }
            }
            return LPS; // Return the computed LPS array
        }
        /* Function to find the shortest palindrome by inserting
        characters at the beginning of given string */
        public String shortestPalindrome(String s) {
            // To store the reverse string
            StringBuilder revs = new StringBuilder(s);
            revs.reverse();
            // Forming the combined string
            String str = s + "$" + revs;
            // Computing the LPS array
            int[] lps = computeLPS(str);
            // Calculating the answer
            int ans = s.length() - lps[lps.length - 1];
        /* Finding the smallest string to be
        added in front of the given string */
            String toAdd = revs.substring(0, ans);
            // Return the result
            return toAdd + s;
        }
        public static void main(String[] args) {
            String s = "aacecaaa";
            ShortestPalindrome sol = new ShortestPalindrome();
            String ans = sol.shortestPalindrome(s);

            System.out.println(ans);
        }
    }

