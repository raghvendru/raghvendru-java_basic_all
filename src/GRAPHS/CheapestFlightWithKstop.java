package GRAPHS;
import java.util.*;

public class CheapestFlightWithKstop {
    public int CheapestFlight(int n, int[][] flights,
                              int src, int dst, int k) {
        // To store the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Adding edges to the graph
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        // To store minimum distance
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        // Add the source to the queue
        q.offer(new int[]{0, src, 0});
        // Until the queue is empty
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int stops = p[0]; // stops
            int node = p[1]; // node
            int dist = p[2]; // distance
            if (stops > k) continue;
            // Traverse all the neighbors
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0]; // Adjacent node
                int edgeWt = neighbor[1]; // Edge weight
                if (dist + edgeWt < minDist[adjNode] &&
                        stops <= k) {

                    // Update the known distance
                    minDist[adjNode] = dist + edgeWt;

                    // Add the new element to the queue
                    q.offer(new int[]{stops + 1, adjNode, dist + edgeWt});
                }
            }
        }
        if (minDist[dst] == Integer.MAX_VALUE)
            return -1;
        return minDist[dst];
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0, dst = 3, k = 1;
        CheapestFlightWithKstop sol = new CheapestFlightWithKstop();
        int ans = sol.CheapestFLight(n, flights, src, dst, k);
        System.out.println("The cheapest flight from source to destination within K stops is: " + ans);
    }
}
