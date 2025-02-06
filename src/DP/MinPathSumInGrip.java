package DP;
import java.util.Arrays;
public class MinPathSumInGrip {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int[] cur = new int[m];
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev[j - 1];
                } else {
                    leftDiagonal = Integer.MAX_VALUE;
                }
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += prev[j + 1];
                } else {
                    rightDiagonal = Integer.MAX_VALUE;
                }
                cur[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            System.arraycopy(cur, 0, prev, 0, m);
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }
        return mini;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        MinPathSumInGrip sol = new MinPathSumInGrip();
        System.out.println(sol.minFallingPathSum(matrix));
    }
}

