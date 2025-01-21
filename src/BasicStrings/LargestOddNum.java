package BasicStrings;
//Largest odd number in a string a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.
//The number returned should not have leading zero's. But the given input string may have leading zero.
//Input : s = "5347"
//Output : "5347"
//Explanation : The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
//So the largest among all the possible odd numbers for given string is 5347.
public class LargestOddNum {
    public String largeOddNum(String s) {
        int ind = -1;

        // Iterate through the string from the end to beginning
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            // Break if an odd digit is found
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }
        // If no odd number was found, return an empty string
        if (ind == -1) return "";

        // Skipping any leading zeroes
        i = 0;
        while(i <= ind && s.charAt(i) == '0') i++;

        // Return the largest odd number substring
        return s.substring(i, ind + 1);
    }

    public static void main(String[] args) {
        LargestOddNum solution = new LargestOddNum();
        String num = "504";
        String result = solution.largeOddNum(num);
        System.out.println("Largest odd number: " + result);
    }
}

