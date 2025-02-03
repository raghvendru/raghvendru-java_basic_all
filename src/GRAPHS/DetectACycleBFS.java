package GRAPHS;
import java.util.*;
public class DetectACycleBFS {
    private boolean bfs(int i,
                        List<Integer> adj[],
                        boolean[] visited) {

        // Queue to store {node, parent}
        Queue<int[]> q = new LinkedList<>();

        /* Push initial node in queue
        with no one as parent */
        q.add(new int[]{i, -1});

        visited[i] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];
            for (int it : adj[node]) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(new int[]{it, node});
                }
                else if (it != parent) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V,
                           List<Integer> adj[]) {
        boolean[] visited = new boolean[V];
        boolean ans = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans = bfs(i, adj, visited);
                if (ans) break;
            }
        }
        return ans;
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
        DetectACycleBFS sol = new DetectACycleBFS();
        boolean ans = sol.isCycle(V, adj);
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}
