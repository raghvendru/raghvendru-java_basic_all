package DP;
import java.util.Arrays;
public class TargetSum {
    private static final int mod = (int)1e9 + 7;
    private int func(int[] num, int target) {
        int n = num.length;
        int[] prev = new int[target + 1];

        if (num[0] == 0)
            // 2 cases - pick and not pick
            prev[0] = 2;
        else
            // 1 case - not pick
            prev[0] = 1;
        if (num[0] != 0 && num[0] <= target)
            // 1 case - pick
            prev[num[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[target + 1];
            for (int tar = 0; tar <= target; tar++) {
                // Number of ways without taking current element
                int notTaken = prev[tar];
                int taken = 0;
                if (num[ind] <= tar)
                    // Number of ways by taking current element
                    taken = prev[tar - num[ind]];
                // Total number of ways for current sum
                cur[tar] = (notTaken + taken) % mod;
            }
            // Update DP state for next iteration
            prev = cur;
        }
        // Return the number of ways
        return prev[target];
    }
    public int targetSum(int n, int target, int[] nums) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }
        if (totSum - target < 0 || (totSum - target) % 2 != 0)
            return 0;
        return func(nums, (totSum - target) / 2);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 3;
        int n = nums.length;
        TargetSum sol = new TargetSum();
        System.out.println("The total number of ways is " + sol.targetSum(n, target, nums));
    }
}

