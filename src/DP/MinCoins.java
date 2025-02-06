package DP;
import java.util.Arrays;
public class MinCoins {
    public int minimumCoins(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int)1e9;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];
                int take = (int)1e9;
                if (coins[ind] <= target)
                    take = 1 + cur[target - coins[ind]];
                cur[target] = Math.min(notTake, take);
            }
            System.arraycopy(cur, 0, prev, 0, amount + 1);
        }
        int ans = prev[amount];
        if (ans >= (int)1e9)
            return -1;
        return ans;
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 7;
        MinCoins sol = new MinCoins();
        System.out.println("The total number of ways is " + sol.minimumCoins(coins, amount));
    }
}

