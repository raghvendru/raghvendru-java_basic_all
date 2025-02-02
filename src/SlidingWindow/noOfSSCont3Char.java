package SlidingWindow;

public class noOfSSCont3Char {
    public int numberOfSubstrings(String s) {

        /* Array to store the last seen
        index of characters 'a', 'b', 'c'*/
        int[] lastSeen = {-1, -1, -1};

        int count = 0;

        // Iterate through each character in string s
        for (int i = 0; i < s.length(); ++i) {

            // Update lastSeen index
            lastSeen[s.charAt(i) - 'a'] = i;

            /* Check if all characters 'a',
            'b', 'c' have been seen*/
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {

                /* Count valid substrings
                ending at current index*/
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }

        // Return the total count of substrings
        return count;
    }

    public static void main(String[] args) {
        String s = "bbacba";

        // Create an instance of Solution class
        noOfSSCont3Char sol = new noOfSSCont3Char();

        int ans = sol.numberOfSubstrings(s);

        // Print the result
        System.out.println("Number of substrings containing 'a', 'b', 'c' in \"" + s + "\" is: " + ans);
    }
}
