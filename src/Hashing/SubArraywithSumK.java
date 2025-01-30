package Hashing;
import java.util.*;
public class SubArraywithSumK {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        // To store the maximum length of the subarray
        int maxLen = 0;

        // Pointers to mark the start and end of window
        int left = 0, right = 0;

        // To store the sum of elements in the window
        int sum = nums[0];
        // Traverse all the elements
        while (right < n) {
            // If the sum exceeds K, shrink the window
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            // Store the maximum length
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) sum += nums[right];
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        // Creating an object of Solution class
        SubArraywithSumK sol = new SubArraywithSumK();
            /* Function call to find the length
        of longest subarray having sum k */
        int ans = sol.longestSubarray(nums, k);
        System.out.println("The length of longest subarray having sum k is: " + ans);
    }
}
