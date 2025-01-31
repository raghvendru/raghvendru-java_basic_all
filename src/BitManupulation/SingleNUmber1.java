package BitManupulation;
import java.util.HashMap;

public class SingleNUmber1 {
        public int singleNumber(int[] nums) {
        /* Variable to store XOR
        of all numbers in array */
            int XOR = 0;

        /* Iterate on the array to
        find XOR of all elements */
            for (int i = 0; i < nums.length; i++) {
                XOR ^= nums[i];
            }

            // XOR stores the required answer
            return XOR;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 2, 4, 3, 1, 4};

        /* Creating an instance of
        Solution class */
            SingleNUmber1 sol = new SingleNUmber1();

        /* Function call to get the single
        number in the given array */
            int ans = sol.singleNumber(nums);

            System.out.println("The single number in given array is: " + ans);
        }

}



