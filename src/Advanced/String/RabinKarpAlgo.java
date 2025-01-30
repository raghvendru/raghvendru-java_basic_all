package Advanced.String;
import java.util.*;
public class RabinKarpAlgo {
        // Function to find the starting index of all occurrences of pattern in text
        public List<Integer> search(String pat, String txt) {
            int n = pat.length();
            int m = txt.length();
            // List to store the result
            List<Integer> ans = new ArrayList<>();
            // Traverse the text string
            for (int i = 0; i <= m - n; i++) {
                boolean flag = true;
                // Check for every character in pattern
                for (int j = 0; j < n; j++) {

                    // If characters does not match
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        flag = false; // Set the flag as false
                        break;
                    }
                }
                // if the pattern is found, store the index
                if (flag) ans.add(i);
            }
            return ans; // Return the stored result
        }
    }

    class Main {
        public static void main(String[] args) {
            String txt = "ababcabcababc";
            String pat = "abc";
            // Creating an instance of Solution class
            RabinKarpAlgo sol = new RabinKarpAlgo();
            List<Integer> ans = sol.search(pat, txt);
            System.out.print("The starting indices of all occurrences of " + pat + " in " + txt + " are: ");
            for (int it : ans) System.out.print(it + " ");
        }
    }

