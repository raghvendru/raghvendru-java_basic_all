package DP;
public class LongestPalindromsubswq {
    private int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        /* Create two arrays to store the
        previous and current rows of DP values */
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        /* Base Case is covered as we have
        initialized the prev and cur to 0. */

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the prev array with current values
            System.arraycopy(cur, 0, prev, 0, m + 1);
        }
        // The value at prev[m] contains length of LCS
        return prev[m];
    }

    public int longestPalinSubseq(String s) {
        // Store a reversed copy of the string
        String t = new StringBuilder(s).reverse().toString();

        /* Call the LCS function to find the
        length of the Longest Common Subsequence */
        return lcs(s, t);
    }


    public static void main(String[] args) {
        String s = "bbabcbcab";

        // Create an instance of Solution class
        LongestPalindromsubswq sol = new LongestPalindromsubswq();

        // Print the result
        System.out.println("The Length of Longest Palindromic Subsequence is " + sol.longestPalinSubseq(s));
    }
}
