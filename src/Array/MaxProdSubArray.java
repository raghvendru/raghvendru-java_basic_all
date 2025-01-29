package Array;
import java.util.*;

public class MaxProdSubArray {
        public int maxProduct(int[] nums) {
            int n = nums.length;

            int ans = Integer.MIN_VALUE; // to store the answer

            // Indices to store the prefix and suffix multiplication
            int prefix = 1, suffix = 1;
            // Iterate on the elements of the given array
            for (int i = 0; i < n; i++) {

            /* Resetting the prefix and suffix
            multiplication if they turn out to be zero */
                if (prefix == 0) prefix = 1;
                if (suffix == 0) suffix = 1;
                // update the prefix and suffix multiplication
                prefix *= nums[i];
                suffix *= nums[n - i - 1];
                // store the maximum as the answer
                ans = Math.max(ans, Math.max(prefix, suffix));
            }
            // return the result
            return ans;
        }
    public static void main(String[] args) {
            int[] nums = {4, 5, 3, 7, 1, 2};
            // Creating an object of Solution class
            MaxProdSubArray sol = new MaxProdSubArray();
        /* Function call to find the product of
        elements in maximum product subarray */
            int ans = sol.maxProduct(nums);
            System.out.println("The product of elements in maximum product subarray is: " + ans);
        }
    }


