package GRAPHS;
import java.util.*;
public class NoOfIsland2 {
    int[] rank, parent, size;
    NoOfIsland2(int n) {
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
            parent[ulp_u] = ulp_v;}
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;}
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
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};
    boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        return true;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        NoOfIsland2 ds = new NoOfIsland2(n * m);
        int[][] vis = new int[n][m];
        for (int[] row : vis) Arrays.fill(row, 0);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for (int[] it : A) {
            int row = it[0]; // Row
            int col = it[1]; // Column
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;}
            vis[row][col] = 1;
            cnt++;
            for (int ind = 0; ind < 4; ind++) {
                int newRow = row + delRow[ind];
                int newCol = col + delCol[ind];
                if (isValid(newRow, newCol, n, m) &&
                        vis[newRow][newCol] == 1) {
                    int nodeNo = row * m + col;
                    int adjNodeNo = newRow * m + newCol;
                    if (ds.findUPar(nodeNo) !=
                            ds.findUPar(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);}}}
            ans.add(cnt);}
        return ans;
    }
    public static void main(String[] args) {
        int n = 4, m = 5, k = 4;
        int[][] A = {
                {1, 1},
                {0, 1},
                {3, 3},
                {3, 4}
        };
        Solution sol = new Solution();
     //   List<Integer> ans = sol.numOfIslands(n, m, A);
        System.out.print("The number of islands after each operations are: ");
//        for (int num : ans) {
//            System.out.print(num + " ");
//        }
    }
}

