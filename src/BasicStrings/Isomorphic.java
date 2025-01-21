package BasicStrings;
//Isomorphic string
//100
//Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//Examples:
//Input : s = "egg" , t = "add"
//Output : true
//Explanation : The 'e' in string s can be replaced with 'a' of string t.
//The 'g' in string s can be replaced with 'd' of t.
//Hence all characters in s can be replaced to get t.
public class Isomorphic {
    public boolean isomorphicString(String s, String t) {
        //your code goes here
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
    public static void main(String[] args) {
        Isomorphic solution = new Isomorphic();
        String s = "egg";
        String t = "add";
        if (solution.isomorphicString(s, t)) {
            System.out.println("Strings are isomorphic.");
        } else {
            System.out.println("Strings are not isomorphic.");
        }
    }
}
