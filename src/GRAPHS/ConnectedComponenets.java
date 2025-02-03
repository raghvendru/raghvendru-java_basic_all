package GRAPHS;
import java.util.*;

public class ConnectedComponenets {
    private void bfs(int node, List<Integer>[] adjLs,
                     boolean[] vis) {
        vis[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        /* Keep on traversing till
        the queue is not empty */
        while (!q.isEmpty()) {
            // Get the node
            int i = q.poll();
            for (int adjNodes : adjLs[i]) {
                if (!vis[adjNodes]) {
                    // Mark the node as visited
                    vis[adjNodes] = true;
                    // Add the node to queue
                    q.add(adjNodes);
                }
            }
        }
    }
    private void dfs(int node, List<Integer>[] adjLs,
                     boolean[] vis) {
        vis[node] = true;
        for (int it : adjLs[node]) {
            if (!vis[it]) {
                dfs(it, adjLs, vis);
            }
        }
    }
    public int findNumberOfComponent(int E, int V,
                                     List<List<Integer>> edges) {
        List<Integer>[] adjLs = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            adjLs[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjLs[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        boolean[] vis = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                bfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int V = 4, E = 2;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2)
        );
        ConnectedComponenets sol = new ConnectedComponenets();
        int ans = sol.findNumberOfComponent(E, V, edges);
        System.out.println("The number of components in the given graph is: " + ans);
    }
}

