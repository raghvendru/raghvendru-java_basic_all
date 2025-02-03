package GRAPHS;
import java.util.*;
public class DetectCycleinDirectedGraph {
    private List<Integer> topoSort(int V,
                                   List<Integer> adj[]) {

        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int it : adj[i]) inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            // Get the node
            int node = q.poll();
            ans.add(node);
            for(int it : adj[node]) {
                // Decrement the in-degree
                inDegree[it]--;
                if(inDegree[it] == 0) q.add(it);
            }
        }

        // Return the result
        return ans;
    }
    public boolean isCyclic(int V, List<Integer> adj[]) {
        List<Integer> topo = topoSort(V, adj);
        if(topo.size() < V) return true;
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1);
        adj[1].add(2);
        adj[1].add(5);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(1);

        // Creating an instance of Solution class
        DetectCycleinDirectedGraph sol = new DetectCycleinDirectedGraph();

        /* Function call to determine if cycle
         exists in given directed graph */
        boolean ans = sol.isCyclic(V, adj);

        // Output
        if(ans)
            System.out.println("The given directed graph contains a cycle.");
        else
            System.out.println("The given directed graph does not contain a cycle.");
    }
}

