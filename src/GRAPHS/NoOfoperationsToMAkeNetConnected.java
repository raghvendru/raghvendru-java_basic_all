package GRAPHS;

public class NoOfoperationsToMAkeNetConnected {
    int[] rank, parent, size;
    NoOfoperationsToMAkeNetConnected(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;}}
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);}
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;}}
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];}
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];}}
    public int solve(int n, int[][] Edge){
        int size = Edge.length;
        if(size < n-1) return -1;
        NoOfoperationsToMAkeNetConnected ds = new NoOfoperationsToMAkeNetConnected(n);
        for(int i=0; i<size; i++) {
            ds.unionByRank(Edge[i][0], Edge[i][1]);
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(ds.parent[i] == i) count++;}
        return count-1;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] Edge = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
      //  NoOfoperationsToMAkeNetConnected sol = new NoOfoperationsToMAkeNetConnected();
       // int ans = sol.Solve(n, Edge);

      //  System.out.println("The number of operations to make network connected is: " + ans);
    }
}

