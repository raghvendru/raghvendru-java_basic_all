package GRAPHS;
import java.util.*;
public class TraversalTechniq {
    private void bfs(int node, List<Integer>[] adj, boolean[] vis,
                     List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int current = q.poll();
            ans.add(current);
            for (int it : adj[current]) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }
    private void dfs(int node, List<Integer>[] adj, boolean[] vis,
                     List<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for (int it : adj[node]) {
            if (!vis[it]) {
                dfs(it, adj, vis, ans);
            }
        }
    }
    public List<Integer> dfsOfGraph(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, ans);
            }
        }
        return ans;
    }
    public List<Integer> bfsOfGraph(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                vis[i] = true;
                bfs(i, adj, vis, ans);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(2, 3, 1));
        adj[1].add(0);
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(0);
        adj[4].add(2);
        TraversalTechniq sol = new TraversalTechniq();
        List<Integer> bfs = sol.bfsOfGraph(V, adj);
        List<Integer> dfs = sol.dfsOfGraph(V, adj);
        System.out.println("The BFS traversal of the given graph is: " + bfs);
        System.out.println("The DFS traversal of the given graph is: " + dfs);
    }
}
