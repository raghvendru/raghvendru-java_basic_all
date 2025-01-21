package BasicStrings;

import java.util.Arrays;

///Longest common prefix
/// Write a function to find the longest common prefix string amongst an array of strings.
/// If there is no common prefix, return an empty string "".
/// Examples:
/// Input : str = ["flowers", "flow" , "fly", "flight" ]
/// Output : "fl"
/// Explanation : All strings given in array contains common prefix "fl".
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        //your code goes here
        StringBuilder ans = new StringBuilder();
        Arrays.sort(str);
        String f = str[0];
        String l = str[str.length-1];
        for(int i = 0 ;i <= Math.min(f.length(),l.length());i++){
            if(f.charAt(i) != l.charAt(i)){
                return ans.toString();
            }
            ans.append(f.charAt(i));
        }
        return  ans.toString();
    }
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] input = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(input);
        System.out.println("Longest Common Prefix: " + result); // Output: "fl"
    }
}
