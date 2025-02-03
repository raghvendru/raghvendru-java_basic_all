package GRAPHS;
import java.util.*;
public class ShortestDistInBinartyMAze {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};
    private boolean isValid(int row, int col,
                            int n, int m) {
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        return true;
    }
    public int shortestPath(int[][] grid, int[] source,
                            int[] destination) {
        if (source[0] == destination[0] &&
                source[1] == destination[1])
            return 0;
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]] = 0;
        q.add(new int[]{0, source[0], source[1]});
        while (!q.isEmpty()) {
            int[] it = q.poll();
            int dis = it[0]; // Distance
            int row = it[1]; // Row of cell
            int col = it[2]; // Column of cell
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (isValid(newRow, newCol, n, m) &&
                        grid[newRow][newCol] == 1 &&
                        dis + 1 < dist[newRow][newCol]) {
                    dist[newRow][newCol] = 1 + dis;
                    if (newRow == destination[0] &&
                            newCol == destination[1])
                        return dis + 1;
                    q.add(new int[]{1 + dis, newRow, newCol});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = {0, 1};
        int[] destination = {2, 2};
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}
        };
        ShortestDistInBinartyMAze sol = new ShortestDistInBinartyMAze();
        int ans = sol.shortestPath(grid, source, destination);
        System.out.println("The shortest distance from the source to destination is: " + ans);
    }
}

