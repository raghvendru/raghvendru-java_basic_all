package GRAPHS;
import java.util.*;
public class BiparatiteGraph {
    private boolean dfs(int node, int col, int[] color,
                        List<Integer> adj[]) {
        color[node] = col;
        for(int it : adj[node]) {
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj) == false)
                    return false;
            }
            else if(color[it] == col) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, List<Integer> adj[]) {

        // To store the color of nodes, where
        // each node is uncolored initially
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Start Traversal of connected components
        for(int i = 0; i < V; i++) {

            if(color[i] == -1) {
                // Start DFS traversal
                // and color each node

                if(dfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2));
        adj[2].addAll(Arrays.asList(1, 3));
        adj[3].addAll(Arrays.asList(0, 2));
        BiparatiteGraph sol = new BiparatiteGraph();
        boolean ans = sol.isBipartite(V, adj);
        if (ans)
            System.out.println("The given graph is a bipartite graph.");
        else
            System.out.println("The given graph is not a bipartite graph.");
    }
}

