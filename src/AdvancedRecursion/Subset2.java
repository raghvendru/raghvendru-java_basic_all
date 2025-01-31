package AdvancedRecursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Subset2 {
        private void func(int ind, List<Integer> arr, int[] nums, List<List<Integer>> ans) {
            // If index reaches the end of nums
            if (ind == nums.length) {
                // Add the current subset (arr) to the result
                ans.add(new ArrayList<>(arr));
                return;
            }
            // Include the current element in the subset
            arr.add(nums[ind]);
            // Recur for the next index
            func(ind + 1, arr, nums, ans);
            // Backtrack: remove the current element from the subset
            arr.remove(arr.size() - 1);

            // Skip duplicates and recur for the next unique element
            for (int j = ind + 1; j < nums.length; j++) {
                if (nums[j] != nums[ind]) {
                    func(j, arr, nums, ans);
                    return;
                }
            }
            // Ensure the function finishes when no more unique elements are left
            func(nums.length, arr, nums, ans);
        }
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();  // Resulting list of subsets
            List<Integer> arr = new ArrayList<>();        // Current subset
            Arrays.sort(nums);  // Sort the array to handle duplicates
            func(0, arr, nums, ans);  // Start recursion
            return ans;
        }
        public static void main(String[] args) {
            Subset2 sol = new Subset2();
            int[] nums = {1, 2, 2};  // Example input
            List<List<Integer>> result = sol.subsetsWithDup(nums);

            // Print the resulting subsets
            for (List<Integer> subset : result) {
                System.out.println(subset);
            }
        }

}
