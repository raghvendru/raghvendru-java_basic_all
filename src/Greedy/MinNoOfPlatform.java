package Greedy;
import java.util.*;
public class MinNoOfPlatform {
        public int findPlatform(int[] Arrival, int[] Departure) {
            int n = Arrival.length;

            // Sort both arrival and departure arrays
            Arrays.sort(Arrival);
            Arrays.sort(Departure);

            int ans = 1;
            int count = 1;
            int i = 1, j = 0;

            // Iterate through the arrays
            while (i < n && j < n) {
                if (Arrival[i] <= Departure[j]) {
                    // Increment count
                    count++;
                    i++;
                } else {
                    // Decrement count
                    count--;
                    j++;
                }
                // Find maximum
                ans = Math.max(ans, count);
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] arr = {900, 945, 955, 1100, 1500, 1800};
            int[] dep = {920, 1200, 1130, 1150, 1900, 2000};

            MinNoOfPlatform sol = new MinNoOfPlatform();
            System.out.println("Minimum number of Platforms required: " + sol.findPlatform(arr, dep));
        }
    }



