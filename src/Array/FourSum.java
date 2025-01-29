package Array;
import java.util.*;
public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            // Sort the input array nums
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                for (int j = i + 1; j < n; j++) {
                    // Skip duplicates for j
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    // Two pointers approach
                    int k = j + 1;
                    int l = n - 1;
                    while (k < l) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            // Found a quadruplet that sums up to target
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            ans.add(temp);
                            // Skip duplicates for k and l
                            k++;
                            l--;
                            while (k < l && nums[k] == nums[k - 1]) k++;
                            while (k < l && nums[l] == nums[l + 1]) l--;
                        } else if (sum < target) {
                            k++;
                        } else {
                            l--;
                        }
                    }
                }
            }
            return ans;
        }
        public static void main(String[] args) {
            int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
            int target = 9;
            // Create an instance of Solution class
            FourSum sol = new FourSum();
            List<List<Integer>> ans = sol.fourSum(nums, target);
            // Print the result
            System.out.println("The quadruplets are: ");
            for (List<Integer> quad : ans) {
                System.out.print("[");
                for (int num : quad) {
                    System.out.print(num + " ");
                }
                System.out.println("]");
            }
        }


}
