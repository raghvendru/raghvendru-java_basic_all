package DP;
import java.util.Arrays;
public class BestTimeTosellStock2 {
    private int func(int[] arr, int n) {
        int[] ahead = new int[2];
        int[] cur = new int[2];
        ahead[0] = ahead[1] = 0;
        int profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max(0 + ahead[0], (-1)*arr[ind] + ahead[1]);
                }
                if (buy == 1) {
                    profit = Math.max(0 + ahead[1], arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }
            ahead = cur;
        }
        return cur[0];
    }
    public int stockBuySell(int[] arr, int n){
        // Return the maximum profit
        return func(arr, n);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};

        // Create an instance of Solution class
        BestTimeTosellStock2 sol = new BestTimeTosellStock2();

        // Call the stockBuySell function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n));
    }
}
