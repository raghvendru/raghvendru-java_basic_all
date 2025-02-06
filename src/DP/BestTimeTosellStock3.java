package DP;

import java.util.Arrays;
public class BestTimeTosellStock3 {
    private int func(int[] arr, int n) {
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
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
            ahead = cur;
        }
        return ahead[0][2];
    }

    // Function to find out maximum profit
    public int stockBuySell(int[] arr, int n) {
        // Return the answer
        return func(arr, n);
    }
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        BestTimeTosellStock3 sol = new BestTimeTosellStock3();
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n));
    }
}

