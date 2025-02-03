package GRAPHS;
import java.util.*;
public class NOofDistinctISlands {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};
    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        return true;
    }
    private void dfs(int row, int col, int[][] grid, boolean[][] visited,
                     List<String> path, int baseRow, int baseCol) {
        int n = grid.length;
        int m = grid[0].length;
        path.add((row - baseRow) + "," + (col - baseCol));
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                visited[nRow][nCol] = true;
                dfs(nRow, nCol, grid, visited, path, baseRow, baseCol);
            }
        }
    }
    public int countDistinctIslands(int[][] grid) {
        // Get the dimensions of grid
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<List<String>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    List<String> path = new ArrayList<>();
                    dfs(i, j, grid, visited, path, i, j);
                    st.add(path);
                }
            }
        }

        return st.size();
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        /* Creating an instance of
        Solution class */
        NOofDistinctISlands sol = new NOofDistinctISlands();

        /* Function to count the number of
        distinct islands in the given grid */
        int ans = sol.countDistinctIslands(grid);

        // Output
        System.out.println("The count of distinct islands in the given grid is: " + ans);
    }
}

