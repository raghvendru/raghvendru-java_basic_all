package GRAPHS;
import java.util.*;

public class MinMultiplicationToReachEnd {
    public int minimumMultiplications(int[] arr,
                                      int start, int end) {
        // Base case
        if (start == end) return 0;
        // Size of array
        int n = arr.length;
        int mod = 100000; // mod
        /* Array to store minimum
        steps (distance array) */
        int[] minSteps = new int[mod];
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        /* Queue to implement
        Dijkstra's algorithm */
        Queue<int[]> q = new LinkedList<>();
        // Mark initial position as 0
        minSteps[start] = 0;

        // Add the initial node to queue
        q.add(new int[]{0, start});

        // Until the queue is empty
        while (!q.isEmpty()) {

            // Get the element
            int[] p = q.poll();

            int steps = p[0]; // steps
            int val = p[1]; // value

            // Check for adjacent neighbors
            for (int i = 0; i < n; i++) {

                // Value of neighboring node
                int num = (val * arr[i]) % mod;

                // If end is reached, return steps taken
                if (num == end) return steps + 1;

                /* Check if the current steps taken is
                less than earlier known steps */
                if (steps + 1 < minSteps[num]) {

                    // Update the known steps
                    minSteps[num] = steps + 1;

                    // Insert the pair in queue
                    q.add(new int[]{steps + 1, num});}}}
        return -1;
    }
    public static void main(String[] args) {
        int start = 3, end = 30;
        int[] arr = {2, 5, 7};
        MinMultiplicationToReachEnd sol = new MinMultiplicationToReachEnd();
        int ans = sol.minimumMultiplications(arr, start, end);
        System.out.println("The minimum multiplications to reach end is: " + ans);
    }
}

