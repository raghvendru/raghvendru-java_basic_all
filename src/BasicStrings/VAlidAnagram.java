package BasicStrings;

import java.util.Arrays;

//Valid Anagram
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//Examples:
//Input : s = "anagram" , t = "nagaram"
//Ouput : true
//Explanation : We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.
public class VAlidAnagram {
    public boolean anagramStrings(String s, String t) {
//        //your code goes here
//        if(s.length() != t.length()) return false;
//        // Convert strings to char arrays and sort them
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        // Compare sorted arrays
//        return Arrays.equals(sArray, tArray);
//    }
        // Edge Cases
        if (s.length() != t.length()) return false;
        // To store the count of each character
        int[] count = new int[26];
        // Count occurrence of each character in first string
        for (char c : s.toCharArray()) count[c - 'a']++;
        // Decrement the count for each character in the second string
        for (char c : t.toCharArray()) count[c - 'a']--;
        // Check for count of every character
        for (int i : count) {
            // If the count is not zero
            if (i != 0) return false; // Return false
        }
        // Otherwise strings are anagra
        return true;
    }

      public static void main(String[] args) {
        VAlidAnagram solution = new VAlidAnagram();
        String str1 = "INTEGER";
        String str2 = "TEGERNI";
        boolean result = solution.anagramStrings(str1, str2);
        System.out.println(result ? "True" : "False");
    }
}
