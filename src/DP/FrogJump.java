package DP;
import java.util.*;
public class FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int prev = 0, prev2 = 0; // Initialize for base cases

        // Iterative calculation
        for (int i = 1; i < n; i++) {
            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (i > 1)
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);

            // Minimum energy for current stair
            int cur_i = Math.min(jumpOne, jumpTwo);
            // Update previous values
            prev2 = prev;
            prev = cur_i;
        }
        // Return the minimum energy required to reach the last stair
        return prev;
    }

    public static void main(String[] args) {
        FrogJump sol = new FrogJump();
        int[] heights = {2, 1, 3, 5, 4};
        int result = sol.frogJump(heights);
        System.out.println("Minimum energy required: " + result);
    }
}

