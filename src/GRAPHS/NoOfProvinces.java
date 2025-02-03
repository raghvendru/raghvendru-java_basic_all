package GRAPHS;
import java.util.*;

public class NoOfProvinces {
    private void bfs(int node, List<Integer> adjLs[], boolean[] vis) {
        vis[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int adjNodes : adjLs[i]) {
                if (!vis[adjNodes]) {
                    vis[adjNodes] = true;
                    q.add(adjNodes);
                }
            }
        }
    }
    private void dfs(int node, List<Integer> adjLs[], boolean[] vis) {
        vis[node] = true;
        for (int it : adjLs[node]) {

            if (!vis[it]) {
                dfs(it, adjLs, vis);
            }
        }
    }
    public int numProvinces(int[][] adj) {

        int V = adj.length;
        List<Integer>[] adjLs = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjLs[i].add(j);
                    adjLs[j].add(i);
                }
            }
        }
        boolean[] vis = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                bfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        NoOfProvinces sol = new NoOfProvinces();
        int ans = sol.numProvinces(adj);
        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}

