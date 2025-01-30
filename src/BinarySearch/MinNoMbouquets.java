package BinarySearch;
public class MinNoMbouquets {
        private boolean possible(int[] nums, int day, int m, int k) {
            int n = nums.length;
            int cnt = 0;
            int noOfB = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= day) {
                    cnt++;
                } else {
                    noOfB += (cnt / k);
                    cnt = 0;
                }
            }
            noOfB += (cnt / k);
            return noOfB >= m;
        }
        public int roseGarden(int n, int[] nums, int k, int m) {
            long val = (long) m * k;
            if (val > n) return -1;
            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                mini = Math.min(mini, nums[i]);
                maxi = Math.max(maxi, nums[i]);
            }
            int left = mini, right = maxi, ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (possible(nums, mid, m, k)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
        public static void main(String[] args) {
            int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
            int n = arr.length;
            int k = 3;
            int m = 2;
            MinNoMbouquets sol = new MinNoMbouquets();
            int ans = sol.roseGarden(n, arr, k, m);
            if (ans == -1) {
                System.out.println("We cannot make m bouquets.");
            } else {
                System.out.println("We can make bouquets on day " + ans);
            }
        }
}
