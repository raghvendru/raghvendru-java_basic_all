package BitManupulation;

public class XorInGivenRange {
        public int findRangeXOR(int l, int r) {

            // To store the XOR of numbers
            int ans = 0;

            // XOR all the numbers
            for (int i = l; i <= r; i++) {
                ans ^= i;
            }

            // Return the result
            return ans;
        }

        public static void main(String[] args) {
            int l = 3, r = 5;

        /* Creating an instance of
        Solution class */
            XorInGivenRange sol = new XorInGivenRange();

        /* Function call to get the
        XOR of numbers from L to R */
            int ans = sol.findRangeXOR(l, r);

            System.out.println("The XOR of numbers from " + l + " to " + r + " is: " + ans);
        }


}
