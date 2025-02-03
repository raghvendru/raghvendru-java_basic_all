package GRAPHS;
import java.util.*;

public class BridgesInGraph {
    private int timer = 1;
    private void dfs(int node, int parent, int[] vis, List<Integer>[] adj,
                     int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for (int it : adj[node]) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[it], low[node]);
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            }
            else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> it : connections) {
            int u = it.get(0), v = it.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> E = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        );
        BridgesInGraph obj = new BridgesInGraph();
        List<List<Integer>> ans = obj.criticalConnections(V, E);

        System.out.println("The critical connections in the given graph are:");
        for (List<Integer> bridge : ans) {
            System.out.println(bridge.get(0) + " " + bridge.get(1));
        }
    }
}

