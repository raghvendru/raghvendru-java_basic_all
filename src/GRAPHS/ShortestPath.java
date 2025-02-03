package GRAPHS;
import java.util.*;

public class ShortestPath {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new int[]{0, 1});
        // Until the queue is empty
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[1]; // node
            int dis = curr[0]; // distance
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0]; // node
                int edWt = neighbor[1]; // edge weight
                if (dis + edWt < dist[adjNode]) {
                    dist[adjNode] = dis + edWt;
                    pq.add(new int[]{dis + edWt, adjNode});
                    parent[adjNode] = node;
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0, dist[n]);
        return path;
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
                {1, 2, 2}, {2, 5, 5}, {2, 3, 4},
                {1, 4, 1}, {4, 3, 3}, {3, 5, 1}
        };
        ShortestPath sol = new ShortestPath();
        List<Integer> ans = sol.shortestPath(n, m, edges);
        System.out.println("The resulting path weight is: " + ans.get(0));
        System.out.println("The path is: ");
        for (int i = 1; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
