package GRAPHS;
import java.util.*;
public class DijkstrasALgoUsingMInHeap {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // TreeSet to store {dist, node}
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // Compare by distance
            return Integer.compare(a[1], b[1]); // If distances are equal, compare by node
        });
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        // Distance of source node from itself is 0
        dist[S] = 0;
        // Adding the source node to the set
        set.add(new int[]{0, S});

        // Until the set is empty
        while (!set.isEmpty()) {
            // Get the pair with the smallest distance
            int[] current = set.pollFirst();
            int dis = current[0];
            int node = current[1];

            // Traverse all its neighbors
            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0); // adjacent node
                int edgeWt = neighbor.get(1); // edge weight

                /* If the tentative distance to
                reach adjacent node is smaller
                than the known distance */
                if (dis + edgeWt < dist[adjNode]) {
                    /* If another longer known distance
                    is found, erase it from the set */
                    set.remove(new int[]{dist[adjNode], adjNode});

                    // Update the known distance
                    dist[adjNode] = dis + edgeWt;

                    // Add the new pair to the set
                    set.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        // Return the result
        return dist;
    }
    public static void main(String[] args) {
        int V = 2, S = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 9)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 9)));
        DijkstrasALgoUsingMInHeap sol = new DijkstrasALgoUsingMInHeap();
        int[] ans = sol.dijkstra(V, adj, S);
        System.out.println("The shortest distance of nodes from the source node is: ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
