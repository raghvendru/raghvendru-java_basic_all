package DP;
import java.util.Arrays;
public class SubsetSumEqualsTarget {
    private boolean func(int n, int target, int[] arr) {
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[target + 1];
            cur[0] = true;
            for (int i = 1; i <= target; i++) {
                boolean notTaken = prev[i];
                boolean taken = false;
                if (arr[ind] <= i) {
                    taken = prev[i - arr[ind]];
                }
                cur[i] = notTaken || taken;
            }
            prev = cur;
        }
        return prev[target];
    }
    public boolean isSubsetSum(int[] arr, int target) {
        // Return the result
        return func(arr.length, target, arr);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;

        // Create an instance of Solution class
        SubsetSumEqualsTarget sol = new SubsetSumEqualsTarget();

        // Call the isSubsetSum function and print the result
        if (sol.isSubsetSum(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
