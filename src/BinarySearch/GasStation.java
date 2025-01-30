package BinarySearch;
import java.util.*;
import java.util.PriorityQueue;
public class GasStation {
            private int numberOfGasStationsRequired(double dist, int[] arr) {
                // Size of the array
                int n = arr.length;
                int cnt = 0;
                for (int i = 1; i < n; i++) {
            /* Calculate number of gas stations
            needed between two points*/
                    int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
                    // Adjust if exact distance fits perfectly
                    if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                        numberInBetween--;
                    }
                    cnt += numberInBetween;
                }
                return cnt;
            }
            /* Function to minimize the maximum
            distance between gas stations*/
            public double minimiseMaxDistance(int[] arr, int k) {
                int n = arr.length;
                double low = 0;
                double high = 0;
                for (int i = 0; i < n - 1; i++) {
                    high = Math.max(high, arr[i + 1] - arr[i]);
                }
        /* Apply Binary search to find the
        minimum possible maximum distance*/
                double diff = 1e-6;
                while (high - low > diff) {
                    double mid = (low + high) / 2.0;
                    int cnt = numberOfGasStationsRequired(mid, arr);
            /* Adjust the search range based on
            the number of gas stations required*/
                    if (cnt > k) {
                        low = mid;
                    } else {
                        high = mid;
                    }
                }
                return high;
            }

            public static void main(String[] args) {
                int[] arr = {1, 2, 3, 4, 5};
                int k = 4;

                // Create an instance of the Solution class
                GasStation sol = new GasStation();

                // Call the minimiseMaxDistance method and print the result
                double ans = sol.minimiseMaxDistance(arr, k);
                System.out.println("The answer is: " + ans);
            }


}
