package GRAPHS;
import java.util.*;
public class DistNearestCellHavingOne {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    private boolean isValid(int i, int j,
                            int n, int m) {
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;
    }
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 1;
                }
                else {
                    vis[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] it = q.poll();
            int row = it[0];
            int col = it[1];
            int steps = it[2];
            dist[row][col] = steps;
            for(int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(isValid(nRow, nCol, n, m) &&
                        vis[nRow][nCol] == 0) {
                    vis[nRow][nCol] = 1;
                    q.add(new int[]{nRow, nCol, steps + 1});}}}
        return dist;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        DistNearestCellHavingOne sol = new DistNearestCellHavingOne();
        int[][] ans = sol.nearest(grid);
        int n = ans.length;
        int m = ans[0].length;
        System.out.println("The distance of the nearest 1 in the grid for each cell is: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

