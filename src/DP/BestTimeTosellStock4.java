package DP;
import java.util.Arrays;
public class BestTimeTosellStock4 {
    private int func(int[] arr, int n, int k) {
        /* Create two 2D arrays to store profit information,
        one for current state and one for the ahead state.*/
        int[][] ahead = new int[2][k+1];
        int[][] cur = new int[2][k+1];

        // Iterate backwards through the prices array
        for (int ind = n - 1; ind >= 0; ind--) {

            // buy can be 0 (buying) or 1 (selling)
            for (int buy = 0; buy <= 1; buy++) {

                /* cap represents the number of
                transactions completed (can be 1 or 2)*/
                for (int cap = 1; cap <= k; cap++) {
                    // We can buy the stock
                    if (buy == 0) {
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                (-1)*arr[ind] + ahead[1][cap]);
                    }
                    // We can sell the stock
                    if (buy == 1) {
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                arr[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            /* Update the ahead state with the
            current state for the next iteration*/
            ahead = cur;
        }

        /* Return the maximum profit after completing
        k transactions starting from index 0*/
        return ahead[0][k];
    }

    // Function to find out maximum profit
    public int stockBuySell(int[] arr, int n, int k) {
        // Return the answer
        return func(arr, n, k);
    }
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 3;
        BestTimeTosellStock4 sol = new BestTimeTosellStock4();
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n, k));
    }
}

