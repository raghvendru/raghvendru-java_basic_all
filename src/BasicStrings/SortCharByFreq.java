package BasicStrings;
import java.util.*;
import java.util.List;
//Sort characters by frequency
//You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
//If two or more characters have same frequency then arrange them in alphabetic order
//Examples:
//Input : s = "tree"
//Output : ['e', 'r', 't' ]
//Explanation : The occurrences of each character are as shown below :
//e --> 2
//r --> 1
//t --> 1.
//The r and t have same occurrences , so we arrange them by alphabetic order.
public class SortCharByFreq {
    public List<Character> frequencySort(String s) {
        // Frequency array for characters 'a' to 'z'
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char)(i + 'a'));
        }
        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }
        // Sort based on frequency (descending) and alphabetically (ascending)
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });
        // Collect result
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0) result.add(p.ch);
        }
        return result;
    }
    // Helper class to store frequency and character
    class Pair {
        int freq;
        char ch;
        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
    // Main method to test the function
    public static void main(String[] args) {
        SortCharByFreq sol = new SortCharByFreq();
        String s = "tree";
        List<Character> result = sol.frequencySort(s);
        System.out.println(result);
    }
}

