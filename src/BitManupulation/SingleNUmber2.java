package BitManupulation;
import java.util.HashMap;
import java.util.Arrays;

public class SingleNUmber2 {
        public int singleNumber(int[] nums) {
            // Two buckets
            int ones = 0, twos = 0;

            // Traverse the array
            for (int i = 0; i < nums.length; i++) {
                // Add the number to Ones, if it is not in Twos
                ones = (ones ^ nums[i]) & ~twos;

                // Add the number to Twos, if it is already in Ones
                twos = (twos ^ nums[i]) & ~ones;
            }

            return ones;
        }


        public static void main(String[] args) {
            int[] nums = {1, 0, 3, 0, 1, 1, 3, 3, 10, 0};

            // Creating an instance of Solution class
            SingleNUmber2 sol = new SingleNUmber2();

            // Function call to find the number that appears only once
            int ans = sol.singleNumber(nums);

            System.out.println("The single number(II) is: " + ans);
        }

            }




