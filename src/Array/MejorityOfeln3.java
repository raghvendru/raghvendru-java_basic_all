package Array;
import java.util.*;
public class MejorityOfeln3 {
        // Function to find majority elements in an array
        public List<Integer> majorityElementTwo(int[] nums) {
            int n = nums.length;
            int cnt1 = 0, cnt2 = 0;
            int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        /*Find the potential candidates using
        Boyer Moore's Voting Algorithm*/
            for (int i = 0; i < n; i++) {
                if (cnt1 == 0 && el2 != nums[i]) {
                    cnt1 = 1;
                    // Initialize el1 as nums[i]
                    el1 = nums[i];
                } else if (cnt2 == 0 && el1 != nums[i]) {
                    cnt2 = 1;
                    // Initialize el2 as nums[i]
                    el2 = nums[i];
                } else if (nums[i] == el1) {
                    // Increment count for el1
                    cnt1++;
                } else if (nums[i] == el2) {
                    // Increment count for el2
                    cnt2++;
                } else {
                    // Decrement count for el1
                    cnt1--;
                    // Decrement count for el2
                    cnt2--;
                }
            }
            //Validate the candidates by counting occurrences in nums:
            //Reset counts for el1 and el2
            cnt1 = 0; cnt2 = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == el1) {
                    // Count occurrences of el1
                    cnt1++;
                }
                if (nums[i] == el2) {
                    // Count occurrences of el2
                    cnt2++;
                }}
        /* Determine the minimum count
        required for a majority element*/
            int mini = n / 3 + 1;
            // List of answers
            List<Integer> result = new ArrayList<>();
        /*Add elements to the result vector
        if they appear more than n/3 times*/
            if (cnt1 >= mini) {
                result.add(el1);
            }
            if (cnt2 >= mini && el1 != el2) {
                // Avoid adding duplicate if el1 == el2
                result.add(el2);
            }
            // Uncomment the following line if you want to sort the answer array
            // Collections.sort(result); // TC --> O(2*log2) ~ O(1);
            //return the majority elements
            return result;
        }
        public static void main(String[] args) {
            int[] arr = {11, 33, 33, 11, 33, 11};
            MejorityOfeln3 sol = new MejorityOfeln3();
            List<Integer> ans = sol.majorityElementTwo(arr);
            System.out.print("The majority elements are: ");
            for (int it : ans) {
                System.out.print(it + " ");
            }
            System.out.println();
        }

}



