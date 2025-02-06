package DP;

import java.util.Arrays;

public class WildcardMatching {
    public boolean wildCard(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        /* Create two arrays to store previous
        and current rows of matching results */
        boolean[] prev = new boolean[m + 1];
        boolean[] cur = new boolean[m + 1];

        /* Initialize the first element
        of the previous row to true */
        prev[0] = true;

        // Initialize the first column
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (str.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            cur[0] = flag;
            for (int j = 1; j <= m; j++) {
                /* If the characters at the current
                positions match or str has a '?' */
                if (str.charAt(i - 1) == pat.charAt(j - 1) || str.charAt(i - 1) == '?') {
                    cur[j] = prev[j - 1];
                }
                else if (str.charAt(i - 1) == '*') {
                    /* Two options: either '*' represents an
                    empty string or it matches a character in pat */
                    cur[j] = prev[j] || cur[j - 1];
                } else {
                    cur[j] = false;
                }
            }
            prev = Arrays.copyOf(cur, m + 1);
        }
        // Return the result
        return prev[m];
    }



    public static void main(String[] args) {
        WildcardMatching sol = new WildcardMatching();
        String str = "abc";
        String pat = "a?c";
        System.out.println(sol.wildCard(str, pat));  // Output: true
    }
}

