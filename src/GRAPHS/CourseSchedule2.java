package GRAPHS;
import java.util.*;
public class CourseSchedule2 {
    private int[] topoSort(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                inDegree[it]++;
            }
        }
        int[] ans = new int[V];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        return Arrays.copyOfRange(ans, 0, idx);
    }
    public int[] findOrder(int N, int[][] arr) {
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        // Form the graph
        for (int[] it : arr) {
            int u = it[0];
            int v = it[1];
            // Add the edge v-> u
            adj[v].add(u);
        }

        // Get the topological ordering of graph
        int[] topo = topoSort(N, adj);
        if (topo.length < N) return new int[0];

        // Return the ordering otherwise
        return topo;
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] arr = {
                {1, 0},
                {2, 1},
                {3, 2}
        };
        CourseSchedule2 sol = new CourseSchedule2();
        int[] ans = sol.findOrder(N, arr);

        // Output
        System.out.println("The order to perform tasks is:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}

