package GRAPHS;
import java.util.*;
public class DisjointSetByRank {
    private int[] rank;
    private int[] size;
    private int[] parent;
    public DisjointSetByRank(int n) {
        // Resize the arrays
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }
    public int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }
    public boolean find(int u, int v) {
        return (findUPar(u) == findUPar(v));
    }
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];}}
    public static void main(String[] args) {
        DisjointSetByRank ds = new DisjointSetByRank(7);
        ds.unionBySize(1, 2); // Adding edge between 1 and 2
        ds.unionBySize(2, 3); // Adding edge between 2 and 3
        ds.unionBySize(4, 5); // Adding edge between 4 and 5
        ds.unionBySize(6, 7); // Adding edge between 6 and 7
        ds.unionBySize(5, 6); // Adding edge between 5 and 6
        if (ds.find(3, 7))
            System.out.println("They belong to the same components.");
        else
            System.out.println("They do not belong to the same components.");
        ds.unionBySize(3, 7); // Adding edge between 3 and 7
        if (ds.find(3, 7))
            System.out.println("They belong to the same components.");
        else
            System.out.println("They do not belong to the same components.");
    }
}
