package GRAPHS;
import java.util.*;
public class KhansALgo {
    public int[] topoSort(int V, List<Integer> adj[]) {
        // To store the result
        int[] ans = new int[V];

        // To store the In-degrees of nodes
        int[] inDegree = new int[V];

        // Calculating the In-degree of the given graph
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) inDegree[it]++;
        }

        // Queue to facilitate BFS
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        int index = 0; // Index to store elements in ans array
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;
            for (int it : adj[node]) {
                // Decrement the in-degree
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
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
        adj[2].add(3);
        adj[3].add(1);
        adj[4].add(0);
        adj[4].add(1);
        adj[5].add(0);
        adj[5].add(2);
        KhansALgo sol = new KhansALgo();
        int[] ans = sol.topoSort(V, adj);
        System.out.println("The topological sorting of the given graph is:");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}