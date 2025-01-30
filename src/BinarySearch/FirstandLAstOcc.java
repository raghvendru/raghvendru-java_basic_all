package BinarySearch;
import java.util.*;
public class FirstandLAstOcc {
        private int firstOccurrence(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int first = -1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(nums[mid] == target) {
                    first = mid;
                    high = mid - 1;
                }
                else if(nums[mid] < target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;}
            }
            return first;
        }
        private int lastOccurrence(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int last = -1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(nums[mid] == target) {
                    last = mid;
                    low = mid + 1;
                }
                else if(nums[mid] < target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;}
            }
            return last;
        }
        public int[] searchRange(int[] nums, int target) {
            int first = firstOccurrence(nums, target);
            if(first == -1) return new int[]{-1, -1};
            int last = lastOccurrence(nums, target);
            return new int[]{first, last};
        }
        public static void main(String[] args) {
            int[] nums = {5, 7, 7, 8, 8, 10};
            int target = 8;
            FirstandLAstOcc sol = new FirstandLAstOcc();
            int[] result = sol.searchRange(nums, target);
            System.out.println("The first and last occurrences are at indices: "
                    + result[0] + " and " + result[1]);
        }

}
