package Array;
import java.util.*;
public class MejorityOfeln2 {
    // Function to find the majority element in an array
        public int majorityElement(int[] nums) {
            // Size of the given array
            int n = nums.length;
            // Iterate through each element of the array
            for (int i = 0; i < n; i++) {
                // Counter to count occurrences of nums[i]
                int cnt = 0;
                // Count the frequency of nums[i] in the array
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        cnt++;
                    }
                }
                // Check if frequency of nums[i] is greater than n/2
                if (cnt > (n / 2)) {
                    // Return the majority element
                    return nums[i];
                }
            }
            // Return -1 if no majority element is found
            return -1;
        }
        public static void main(String[] args) {
            int[] arr = {2, 2, 1, 1, 1, 2, 2};

            // Create an instance of Solution class
            MejorityOfeln2 sol = new MejorityOfeln2();

            int ans = sol.majorityElement(arr);

            // Print the majority element found
            System.out.println("The majority element is: " + ans);
        }

}
