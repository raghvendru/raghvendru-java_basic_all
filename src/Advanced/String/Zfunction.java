package Advanced.String;
import java.util.*;
public class Zfunction {
        // Compute the Z array for the combined string
        private List<Integer> computeZ_array(String s) {
            int n = s.length(); // size of string
            List<Integer> Z =
                    new ArrayList<>(Collections.nCopies(n, 0)); // Z-array
            // For every character
            for (int i = 1; i < n; i++) {
                // Increment Z[i] till the characters matches with the prefix
                while (i + Z.get(i) < n &&
                        s.charAt(i + Z.get(i)) == s.charAt(Z.get(i))) {
                    Z.set(i, Z.get(i) + 1);
                }
            }
            return Z; // Return the computed Z-array
        }
        // Funcion to find all indices of pattern in text
        public List<Integer> search(String text, String pattern) {
            String s = pattern + '$' + text; // Combined string
            // Function call to find the Z array for the combined string
            List<Integer> Z = computeZ_array(s);
            // Length of pattern and text
            int n = text.length(), m = pattern.length();
            // To store the result
            List<Integer> ans = new ArrayList<>();
            // Iterate on the combined string after the delimiter
            for (int i = m + 1; i < s.length(); i++) {
                if (Z.get(i) == m) ans.add(i - (m + 1));
            }
            return ans;
        }

        public static void main(String[] args) {
            String text = "xyzabxyzabxyz";
            String pattern = "xyz";
            Zfunction sol = new Zfunction();
            List<Integer> ans = sol.search(text, pattern);
            for (int ind : ans) {
                System.out.print(ind + " ");
            }

    }


}
