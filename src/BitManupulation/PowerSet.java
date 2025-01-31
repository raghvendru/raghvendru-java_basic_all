package BitManupulation;
import java.util.*;

public class PowerSet {
        public List<List<Integer>> powerSet(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            int count = (1 << n);
            // Traverse for every value
            for (int val = 0; val < count; val++) {
                // To store the current subset
                List<Integer> subset = new ArrayList<>();
                // Traverse on n bits
                for (int i = 0; i < n; i++) {
                    if ((val & (1 << i)) != 0) {
                        subset.add(nums[i]);
                    }
                }
            /* Add the current subset
            to final answer */
                ans.add(subset);
            }
            // Return stored answer
            return ans;
        }
        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            PowerSet sol = new PowerSet();
            List<List<Integer>> ans = sol.powerSet(nums);
            ans.sort(Comparator.comparingInt(List::size));
            System.out.println("The power set for the given array is: ");
            for (List<Integer> subset : ans) {
                for (int num : subset) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

