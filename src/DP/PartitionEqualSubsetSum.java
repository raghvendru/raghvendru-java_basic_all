package DP;
public class PartitionEqualSubsetSum {
    private boolean func(int n, int[] arr) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }
        if (totSum % 2 == 1)
            return false;
        else {
            int k = totSum / 2;
            boolean[] prev = new boolean[k + 1];
            prev[0] = true;
            if (arr[0] <= k)
                prev[arr[0]] = true;
            for (int ind = 1; ind < n; ind++) {
                boolean[] cur = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];
                    boolean taken = false;
                    if (arr[ind] <= target)
                        taken = prev[target - arr[ind]];
                    cur[target] = notTaken || taken;
                }
                prev = cur;
            }
            return prev[k];
        }
    }
    public boolean equalPartition(int n, int[] arr) {
        // Return the result
        return func(n, arr);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;
        PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();
        if (sol.equalPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
