package GRAPHS;
import java.util.*;
public class CityWithSmallestNeighbour {
    public int findCity(int n, int m, int[][] edges,
                        int distanceThreshold) {

        // Adjacency matrix to store the graph
        int[][] adjMat = new int[n][n];
        for (int[] row : adjMat) Arrays.fill(row, (int)1e9);

        for(int[] it : edges) {
            adjMat[it[0]][it[1]] = it[2];
            adjMat[it[1]][it[0]] = it[2];
        }

        for(int k = 0; k < n; k++) {

            // node i ---> node j
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    adjMat[i][j] =
                            Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);}}}
        int minCount = (int)1e9;
        int ans = -1;
        // Check every city
        for(int i = 0; i < n; i++) {
            int count = 0;

            // City i ---> City j
            for(int j = 0; j < n; j++) {
                if(i != j && adjMat[i][j] <= distanceThreshold) {

                    // Increment count
                    count++;
                }
            }
            if(count < minCount) {
                minCount = count;

                // Store the answer
                ans = i;
            }
            else if(count == minCount) {

                /* Update the answer (to store
                city with greater number) */
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 4, M = 4;
        int[][] edges = {
                {0, 1, 3}, {1, 2, 1},
                {1, 3, 4}, {2, 3, 1}
        };
        int distanceThreshold = 4;
        CityWithSmallestNeighbour sol = new CityWithSmallestNeighbour();
        int ans = sol.findCity(N, M, edges, distanceThreshold);
        System.out.println("The city with smallest number of neighbors (with given threshold) is: " + ans);
    }
}

