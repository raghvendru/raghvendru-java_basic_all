package DP;

import java.util.Arrays;

public class KnapScak01 {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        /* Initialize a vector 'prev' to represent
        the previous row of the DP table*/
        int[] prev = new int[W + 1];

        /* Base condition: Fill in 'prev'
        for the weight of the first item*/
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        // Fill in the table using a bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int cap = W; cap >= 0; cap--) {
                /* Calculate the maximum value by either
                excluding the current item or including it*/
                int notTaken = prev[cap];
                int taken = Integer.MIN_VALUE;

                /* Check if the current item can be included
                without exceeding the knapsack's capacity*/
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                // Update 'prev' for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        /* The final result is in the
        last cell of the 'prev' vector*/
        return prev[W];
    }




    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;
        KnapScak01 sol = new KnapScak01();
        int result = sol.knapsack01(wt, val, n, W);
        System.out.println("The Maximum value of items is " + result);
    }
}

