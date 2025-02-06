package DP;
import java.util.Arrays;
public class PartionSetinto2Subset {
    public int minDifference(int[] arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        /* Initialize a boolean vector 'prev' to
        represent the previous row of the DP table */
        boolean[] prev = new boolean[totSum + 1];
        Arrays.fill(prev, false);
        prev[0] = true;
        if (arr[0] <= totSum)
            prev[arr[0]] = true;
        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[totSum + 1];
            Arrays.fill(cur, false);
            cur[0] = true;
            for (int target = 1; target <= totSum; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr[ind] <= target)
                    taken = prev[target - arr[ind]];
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        PartionSetinto2Subset sol = new PartionSetinto2Subset();
        System.out.println("The minimum absolute difference is: " + sol.minDifference(arr, n));
    }
}

