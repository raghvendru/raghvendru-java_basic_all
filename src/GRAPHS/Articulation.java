package GRAPHS;
import java.util.*;

public class Articulation {
    private int timer = 1;
    private void dfs(int node, int parent, boolean[] vis,
                     int[] tin, int[] low, boolean[] mark,
                     ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (!vis[it]) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = true;
        }
    }
    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                ans.add(i);
            }
        }
        if (ans.size() == 0)
            return new ArrayList<>(Arrays.asList(-1));
        return ans;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(1).addAll(Arrays.asList(0));
        adj.get(2).addAll(Arrays.asList(0, 3, 4, 5));
        adj.get(3).addAll(Arrays.asList(2, 0));
        adj.get(4).addAll(Arrays.asList(2, 6));
        adj.get(5).addAll(Arrays.asList(2, 6));
        adj.get(6).addAll(Arrays.asList(4, 5));
        Articulation obj = new Articulation();
        ArrayList<Integer> nodes = obj.articulationPoints(V, adj);
        for (int node : nodes) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

