package DP;
import java.util.Arrays;
public class BestTimeTosellStockWithFees {
    private int func(int[] arr, int n, int fee) {
        int[] ahead = new int[2];
        int[] cur = new int[2];
        // Iterate backwards through the prices array
        for (int ind = n - 1; ind >= 0; ind--) {
            // buy can be 0 (buying) or 1 (selling)
            for (int buy = 0; buy <= 1; buy++) {
                // We can buy the stock
                if (buy == 0) {
                    cur[buy] = Math.max(0 + ahead[0],(-1)*arr[ind] + ahead[1]);
                }
                // We can sell the stock
                if (buy == 1) {
                    cur[buy] = Math.max(0 + ahead[1],arr[ind]-fee + ahead[0]);
                }
            }
            ahead = cur;
        }
        // Return the maximum profit
        return cur[0];
    }
    // Function to find out maximum profit
    public int stockBuySell(int[] arr, int n, int fee) {
        // Return the answer
        return func(arr, n, fee);
    }


    public static void main(String[] args) {
        int n = 8;
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        int fee = 1;
        BestTimeTosellStockWithFees sol = new BestTimeTosellStockWithFees();
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n, fee));
    }
}

