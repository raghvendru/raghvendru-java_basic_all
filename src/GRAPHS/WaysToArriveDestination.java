package GRAPHS;
import java.util.*;

public class WaysToArriveDestination {
    public int countPaths(int n, List<List<Integer>> roads) {
        int mod = 1000000007; // Mod value
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> it : roads) {
            adj[it.get(0)].add(new int[]{it.get(1), it.get(2)});
            adj[it.get(1)].add(new int[]{it.get(0), it.get(2)});
        }
        long[] minTime = new long[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minTime[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            long time = p[0]; // time
            int node = (int) p[1]; // node
            for (int[] it : adj[node]) {
                int adjNode = it[0]; // adjacent node
                int travelTime = it[1]; // travel time
                if (minTime[adjNode] > time + travelTime) {
                    minTime[adjNode] = time + travelTime;
                    ways[adjNode] = ways[node];
                    pq.add(new long[]{minTime[adjNode], adjNode});
                }
                else if (minTime[adjNode] == time + travelTime) {

                    /* Update the number of ways
                    to reach adjacent nodes */
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;}}}
        return ways[n - 1] % mod;
    }
    public static void main(String[] args) {
        int n = 7, m = 20;
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(0, 6, 7),
                Arrays.asList(0, 1, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 3),
                Arrays.asList(6, 3, 3),
                Arrays.asList(3, 5, 1),
                Arrays.asList(6, 5, 1),
                Arrays.asList(2, 5, 1),
                Arrays.asList(0, 4, 5),
                Arrays.asList(4, 6, 2)
        );
        WaysToArriveDestination sol = new WaysToArriveDestination();
        int ans = sol.countPaths(n, roads);
        System.out.println("The number of ways to arrive at destinations in shortest possible time is: " + ans);
    }
}

