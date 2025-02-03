package GRAPHS;
import java.util.*;
public class ShortestPAthinUndirectedGraph {
    // Function to perform BFS traversal
    private void bfs(int src, List<Integer>[] adj,
                     int[] dist) {
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int adjNode : adj[node]) {

                // If a shorter distance is found
                if (dist[node] + 1 < dist[adjNode]) {

                    // Update the distance
                    dist[adjNode] = 1 + dist[node];

                    // Add the node to the queue
                    q.add(adjNode);
                }
            }
        }
    }
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0]; // first node
            int v = edge[1]; // second node
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(0, adj, dist);
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        int N = 9, M = 10;
        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4},
                {4, 5}, {5, 6}, {1, 2},
                {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        ShortestPAthinUndirectedGraph sol = new ShortestPAthinUndirectedGraph();
        int[] ans = sol.shortestPath(edges, N, M);

        // Output
        System.out.println("The shortest distance of every node from source node is:");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
