package GRAPHS;
import java.util.*;
public class MstWeightPrimes {
    List<Integer> rank, parent, size;
    public MstWeightPrimes(int n) {
        rank = new ArrayList<>(n + 1);
        Collections.fill(rank, 0);
        parent = new ArrayList<>(n + 1);
        size = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node) {
        if (node == parent.get(node))
            return node;
        parent.set(node, findUPar(parent.get(node)));
        return parent.get(node);
    }
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        // To store the edges
        List<int[]> edges = new ArrayList<>();
        // Getting all edges from adjacency list
        for (int i = 0; i < V; i++) {
            for (List<Integer> it : adj.get(i)) {
                int v = it.get(0); // Node v
                int wt = it.get(1); // edge weight
                int u = i; // Node u
                edges.add(new int[]{wt, u, v});
            }
        }
        // Creating a disjoint set of V vertices
        MstWeightPrimes ds = new MstWeightPrimes(V);
        // Sorting the edges based on their weights
        edges.sort(Comparator.comparingInt(o -> o[0]));
        // To store the sum of edges in MST
        int sum = 0;
        // Iterate on the edges
        for (int[] it : edges) {
            int wt = it[0]; // edge weight
            int u = it[1]; // First node
            int v = it[2]; // Second node

            // Join the nodes if not in the same set
            if (ds.findUPar(u) != ds.findUPar(v)) {

                // Update the sum of edges in MST
                sum += wt;

                // Unite the nodes
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int V = 4;
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1, 1},
                new int[]{1, 2, 2},
                new int[]{2, 3, 3},
                new int[]{0, 3, 4}
        );
        // Forming the adjacency list from edges
        List<List<List<Integer>>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            adj.get(u).add(Arrays.asList(v, wt));
            adj.get(v).add(Arrays.asList(u, wt));
        }
        Solution sol = new Solution();
        int ans = sol.spanningTree(V, adj);

        System.out.println("The sum of weights of edges in MST is: " + ans);
    }

}

