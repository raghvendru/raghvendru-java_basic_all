package GRAPHS;
import java.util.*;
public class ShortestPathDAG {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    private void topoSort(int node, List<List<Pair>> adj,
                          boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (Pair it : adj.get(node)) {
            int v = it.first;
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // node 1
            int v = edges[i][1]; // node 2
            int wt = edges[i][2]; // edge weight
            adj.get(u).add(new Pair(v, wt));
        }
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }
        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair it : adj.get(node)) {
                int v = it.first; // adjacent node
                int wt = it.second; // edge weight
                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int)1e9)
                dist[i] = -1;
        }
        return dist;
    }
    public static void main(String[] args) {
        int N = 4, M = 2;
        int[][] edges = {
                {0, 1, 2}, {0, 2, 1}
        };
        ShortestPathDAG sol = new ShortestPathDAG();
        int[] ans = sol.shortestPath(N, M, edges);
        System.out.println("The shortest distance of every node from source node is:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}

