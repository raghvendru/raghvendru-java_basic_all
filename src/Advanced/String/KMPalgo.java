package Advanced.String;
import java.util.*;
public class KMPalgo {
        private int[] computeLPS(String s) {
            int n = s.length(); // size of string
            // To store the longest prefix suffix
            int[] LPS = new int[n];
            // Iterate on the string
            for (int i = 1; i < n; i++) {
                // For all possible lengths
                for (int len = 1; len < i; len++) {
                    if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                        LPS[i] = len;
                    }
                }
            }
            return LPS; // Return the computed LPS array
        }
        // Function to find all indices of pattern in text
        public List<Integer> search(String pattern, String text) {
            String s = pattern + '$' + text; // Combined string
            // Function call to find the LPS array for the combined string
            int[] LPS = computeLPS(s);
            // Length of pattern and text
            int n = text.length(), m = pattern.length();
            // To store the result
            List<Integer> ans = new ArrayList<>();
            // Iterate on the combined string after the delimiter
            for (int i = m + 1; i < s.length(); i++) {
                if (LPS[i] == m) ans.add(i - 2 * m);
            }
            return ans;
        }
        public static void main(String[] args) {
            String text = "xyzabxyzabxyz";
            String pattern = "xyz";
            KMPalgo sol = new KMPalgo();
            List<Integer> ans = sol.search(pattern, text);
            for (int ind : ans) {
                System.out.print(ind + " ");
            }
        }
    }

