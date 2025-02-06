package DP;
import java.util.Arrays;
public class CountPartitionGivendifference {
    private static final int MOD = (int) 1e9 + 7;
    private int findWays(int[] num, int tar) {
        int n = num.length;
        int[] prev = new int[tar + 1];
        if (num[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        if (num[0] != 0 && num[0] <= tar) prev[num[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (num[ind] <= target)
                    taken = prev[target - num[ind]];
                cur[target] = (notTaken + taken) % MOD;
            }
            prev = cur;
        }
        return prev[tar];
    }
    public int countPartitions(int n, int diff, int[] arr) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }
        if (totSum - diff < 0 || (totSum - diff) % 2 != 0) return 0;

        // Calculate the target sum for one subset.
        return findWays(arr, (totSum - diff) / 2);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int n = arr.length;
        int diff = 3;
        CountPartitionGivendifference sol = new CountPartitionGivendifference();
        System.out.println("The number of subsets found are " + sol.countPartitions(n, diff, arr));
    }
}

