package BinarySearch;
public class SplitArrayLargestSum {
        private int countPartitions(int[] a, int maxSum) {
            int n = a.length;
            int partitions = 1;
            long subarraySum = 0;
            for (int i = 0; i < n; i++) {
                if (subarraySum + a[i] <= maxSum) {
                    // Add element to the current subarray
                    subarraySum += a[i];
                } else {
                    // Start a new subarray with current element
                    partitions++;
                    subarraySum = a[i];
                }
            }
            return partitions;
        }
        public int largestSubarraySumMinimized(int[] a, int k) {
            // Initialize binary search boundaries
            int low = a[0];
            int high = 0;
            //Find maximum and summation
            for (int i = 0; i < a.length; i++) {
                low = Math.max(low, a[i]);
                high += a[i];
            }
            while (low <= high) {
                int mid = (low + high) / 2;
                int partitions = countPartitions(a, mid);
                if (partitions > k) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public static void main(String[] args) {
            int[] a = {10, 20, 30, 40};
            int k = 2;
            SplitArrayLargestSum sol = new SplitArrayLargestSum();
            int ans = sol.largestSubarraySumMinimized(a, k);
            System.out.println("The answer is: " + ans);
        }
}
