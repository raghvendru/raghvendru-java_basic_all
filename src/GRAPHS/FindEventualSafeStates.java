package GRAPHS;
import java.util.*;
public class FindEventualSafeStates {
    private int[] topoSort(int V,
                           List<Integer>[] adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int it : adj[i]) {
                inDegree[it]++;
            }
        }
        int[] ans = new int[V];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;
            for(int it : adj[node]) {
                inDegree[it]--;
                if(inDegree[it] == 0) q.add(it);
            }
        }
        return Arrays.copyOfRange(ans, 0, idx);
    }
    public int[] eventualSafeNodes(int V,
                                   int[][] adj) {
        ArrayList<Integer>[] adjRev = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adjRev[i] = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {

                // Add the edge to reversed graph
                adjRev[it].add(i);
            }
        }
        int[] result = topoSort(V, adjRev);

        // Sort the result
        Arrays.sort(result);

        // Return the result
        return result;
    }
    public static void main(String[] args) {
        int V = 7;
        int[][] adj = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        FindEventualSafeStates sol = new FindEventualSafeStates();
        int[] ans = sol.eventualSafeNodes(V, adj);
        System.out.println("The eventually safe nodes in the graph are:");
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}

