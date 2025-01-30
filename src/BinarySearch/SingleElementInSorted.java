package BinarySearch;
import java.util.*;
public class SingleElementInSorted {
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length; // Size of the array.
            // Edge cases:
            if (n == 1) return nums[0];
            if (nums[0] != nums[1]) return nums[0];
            if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

            int low = 1, high = n - 2;
            while (low <= high) {
                int mid = (low + high) / 2;
                // If nums[mid] is the single element:
                if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                }
                // We are in the left part:
                if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                        || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                    // Eliminate the left half:
                    low = mid + 1;
                }
                // We are in the right part:
                else {
                    // Eliminate the right half:
                    high = mid - 1;
                }
            }

            // Dummy return statement:
            return -1;
        }

        public static void main(String[] args) {
            int[] nums = {1, 1, 2, 2, 3, 3, 4};
            SingleElementInSorted sol = new SingleElementInSorted();
            int ans = sol.singleNonDuplicate(nums);
            System.out.println("The single element is: " + ans);
        }
    }



