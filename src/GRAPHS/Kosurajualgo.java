package GRAPHS;
import java.util.*;
public class Kosurajualgo {
    private void dfs(int node, int[] vis,
                     ArrayList<ArrayList<Integer>> adj,
                     Stack<Integer> st) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    private void helperDFS(int node, int[] vis,
                           ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (int it : adjT.get(node)) {
            if (vis[it] == 0) {
                helperDFS(it, vis, adjT);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }
        int count = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                count += 1;
                helperDFS(node, vis, adjT);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);
        Kosurajualgo sol = new Kosurajualgo();
        int count = sol.kosaraju(V, adj);
        System.out.println("Number of strongly connected components: " + count);
    }
}

