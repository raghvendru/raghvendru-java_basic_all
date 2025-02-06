package DP;
import java.util.Arrays;
public class UbiquePath2 {
    private int func(int m, int n, int[][] matrix) {
        /* Initialize a vector to store
        the previous row's path counts*/
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            /* Initialize a temporary
            vector for the current row*/
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                // Base conditions
                if (i > 0 && j > 0 && matrix[i][j] == 1) {
                    /* If there's an obstacle at (i, j),
                    no paths can pass through it*/
                    temp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                /* Check if we can move up and left
                (if not at the edge of the maze)*/
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];
                /* Total number of paths to reach (i, j)
                is the sum of paths from above and left*/
                temp[j] = up + left;
            }
            // Update the previous row with the current row
            prev = temp;
        }
        return prev[n - 1];
    }
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        return func(m, n, matrix);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        // Create an instance of Solution class
        UbiquePath2 sol = new UbiquePath2();

        System.out.println("Number of paths with obstacles: " + sol.uniquePathsWithObstacles(maze));
    }
}

