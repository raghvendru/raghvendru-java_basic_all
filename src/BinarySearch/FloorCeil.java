package BinarySearch;
import java.util.*;

public class FloorCeil {
        private int findFloor(int[] nums, int n, int x) {
            int low = 0, high = n - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] <= x) {
                    ans = nums[mid];
                    low = mid + 1;}
                else {
                    high = mid - 1;}
            }
            return ans;
        }
        private int findCeil(int[] nums, int n, int x) {
            int low = 0, high = n - 1;
            int ans = -1;
            // Perform binary search to find ceil value
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] >= x) {
                    ans = nums[mid];
                    high = mid - 1;}
                else {
                    low = mid + 1;}
            }
            return ans;
        }
        public int[] getFloorAndCeil(int[] nums, int x) {
            int n = nums.length;
            int floor = findFloor(nums, n, x);
            int ceil = findCeil(nums, n, x);
            return new int[] {floor,ceil};
        }
        public static void main(String[] args) {
            int[] nums = {3, 4, 4, 7, 8, 10};
            int x = 5;
            FloorCeil sol = new FloorCeil();
            int[] result = sol.getFloorAndCeil(nums, x);

            System.out.println("The floor and ceil are: " + result[0] + " " + result[1]);

    }
}
