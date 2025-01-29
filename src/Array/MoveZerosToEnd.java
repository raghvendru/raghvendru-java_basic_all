package Array;
import java.util.*;
public class MoveZerosToEnd {
    // Function to move zeroes to the end
//        public void moveZeroes(int[] nums) {
//            int n = nums.length;
//
//            // Create a temporary array to store non-zero elements
//            int[] temp = new int[n];
//            int count = 0;
//
//            // Copy non-zero elements to temp
//            for (int i = 0; i < n; i++) {
//                if (nums[i] != 0) {
//                    temp[count++] = nums[i];
//                }
//            }
//
//            // Copy non-zero elements back to nums
//            for (int i = 0; i < count; i++) {
//                nums[i] = temp[i];
//            }
//
//            // Fill the rest with zeroes
//            for (int i = count; i < n; i++) {
//                nums[i] = 0;
//            }
//        }
    public void moveZeroes(int[] nums) {
        int j = 0; // Initialize j to 0

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // Fill the remaining elements with zeros
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

        public static void main(String[] args) {
            int[] nums = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
            // Create an instance of Solution class
            MoveZerosToEnd sol = new MoveZerosToEnd();
            sol.moveZeroes(nums);
            System.out.print("Array after moving zeroes: ");
            // Print the modified array
            System.out.println(Arrays.toString(nums));
        }

}
