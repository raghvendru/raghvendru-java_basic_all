package GRAPHS;
import java.util.*;
public class FloodFill {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};

    /* Helper Function to check if a
    pixel is within boundaries */
    private boolean isValid(int i, int j,
                            int n, int m) {

        // Return false if pixel is invalid
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;

        // Return true if pixel is valid
        return true;
    }
    private void dfs(int row, int col, int[][] ans,
                     int[][] image, int newColor,
                     int iniColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            // Coordinates of new pixel
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (isValid(nrow, ncol, n, m) &&
                    image[nrow][ncol] == iniColor &&
                    ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image,
                        newColor, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr,
                             int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }
        dfs(sr, sc, ans, image, newColor, iniColor);
        return ans;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1;
        int newColor = 2;
        FloodFill sol = new FloodFill();
        int[][] ans = sol.floodFill(image, sr, sc, newColor);
        System.out.println("Image after performing flood fill algorithm:\n");
        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

