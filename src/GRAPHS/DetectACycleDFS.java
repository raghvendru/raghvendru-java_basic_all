package GRAPHS;
import java.util.*;
public class DetectACycleDFS {
    private boolean dfs(int i, List<Integer> adj[],
                        boolean[] visited, int prev) {
        // Mark the node as visited
        visited[i] = true;

        // Traverse all the neighbors
        for (int node : adj[i]) {

            // If not visited
            if (!visited[node]) {

                /* Recursively perform DFS, and
                return true if cycle is found */
                if (dfs(node, adj, visited, i)) {
                    return true;
                }
            }
            else if (node != prev) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer> adj[]) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));
        DetectACycleDFS sol = new DetectACycleDFS();
        boolean ans = sol.isCycle(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}
