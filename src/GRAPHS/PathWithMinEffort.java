package GRAPHS;
import java.util.*;
public class PathWithMinEffort {
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, -1, 0, 1};
    boolean isValid(int row, int col, int n, int m) {
        // Return false if the cell is invalid
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        return true;
    }
    public int MinimumEffort(List<List<Integer>> heights) {
        int n = heights.size();
        int m = heights.get(0).size();
        int[][] maxDiff = new int[n][m];
        for (int[] row : maxDiff)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        maxDiff[0][0] = 0;
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int diff = p[0];

            int row = p[1]; // Row
            int col = p[2]; // Column

            /* If the destination cell is reached,
            return the difference */
            if (row == n - 1 && col == m - 1)
                return diff;

            // Traverse its neighbors
            for (int i = 0; i < 4; i++) {

                /* Get the coordinates
                of neighboring cell */
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                // Check if the cell is valid
                if (isValid(newRow, newCol, n, m)) {
                    int currDiff = Math.abs(heights.get(newRow).get(newCol) - heights.get(row).get(col));
                    if (Math.max(currDiff, diff) < maxDiff[newRow][newCol]) {
                        maxDiff[newRow][newCol] = Math.max(currDiff, diff);
                        pq.add(new int[]{Math.max(currDiff, diff), newRow, newCol});}}}}
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> heights = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(3, 8, 2),
                Arrays.asList(5, 3, 5)
        );
        PathWithMinEffort sol = new PathWithMinEffort();
        int ans = sol.MinimumEffort(heights);
        System.out.println("The minimum efforts required to go from cell (0,0) to cell (row-1, col-1) is: " + ans);
    }
}

