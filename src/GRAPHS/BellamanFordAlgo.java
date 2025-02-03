package GRAPHS;
import java.util.*;
public class BellamanFordAlgo {
    public int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges,
                              int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        for(int i = 0; i < V-1; i++) {
            for(ArrayList<Integer> it : edges) {

                int u = it.get(0); // node 1
                int v = it.get(1); // node 2
                int wt = it.get(2); // edge weight

                // Edge relaxation
                if(dist[u] != 1e9 &&
                        dist[u] + wt < dist[v]) {

                    // Updating the known distance
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(ArrayList<Integer> it : edges) {
            int u = it.get(0); // node 1
            int v = it.get(1); // node 2
            int wt = it.get(2); // edge weight
            if(dist[u] != 1e9 &&
                    dist[u] + wt < dist[v]) {

                // Return {-1}
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 6, S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(3, 2, 6)));
        edges.add(new ArrayList<>(Arrays.asList(5, 3, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 5, -3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4, -2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 3)));
        BellamanFordAlgo sol = new BellamanFordAlgo();
        int[] ans = sol.bellman_ford(V, edges, S);
        if(ans.length == 1 && ans[0] == -1)
            System.out.println("The graph contains negative cycle.");
        else{
            System.out.print("The shortest distance from source is: ");
            for(int i = 0; i < V; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }

}
