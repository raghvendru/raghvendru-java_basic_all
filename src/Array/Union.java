package Array;
import java.util.*;

public class Union {
//        public int[] unionArray(int[] nums1, int[] nums2) {
//            Set<Integer> set = new TreeSet<>();
//            // Insert all elements of nums1 into the set
//            for (int num : nums1) {
//                set.add(num);
//            }
//            // Insert all elements of nums2 into the set
//            for (int num : nums2) {
//                set.add(num);
//            }
//            // Convert the set to an integer array to get the union
//            int[] union = new int[set.size()];
//            int index = 0;
//            for (int num : set) {
//                union[index++] = num;
//            }
//            return union;
//        }
public int[] unionArray(int[] nums1, int[] nums2) {
    List<Integer> UnionList = new ArrayList<>();
    int i = 0, j = 0;
    int n = nums1.length;
    int m = nums2.length;
    while (i < n && j < m) {
        if (nums1[i] <= nums2[j]) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        }
        else {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }
    }// Add remaining elements of nums1, if any
    while (i < n) {
        if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
            UnionList.add(nums1[i]);
        }
        i++;
    }// Add remaining elements of nums2, if any
    while (j < m) {
        if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
            UnionList.add(nums2[j]);
        }
        j++;
    }
    // Convert List<Integer> to int[]
    int[] Union = new int[UnionList.size()];
    for (int k = 0; k < UnionList.size(); k++) {
        Union[k] = UnionList.get(k);
    }
    return Union;
}
         public static void main(String[] args) {
             // Initialize the arrays
             int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
             int[] nums2 = {2, 3, 4, 4, 5, 11, 12};
             // Create an instance of the Solution class
             Union finder = new Union();
            /* Get the union of nums1 and
        nums2 using the class method */
             int[] union = finder.unionArray(nums1, nums2);
             System.out.println("Union of nums1 and nums2 is:");
             for (int val : union) {
                 System.out.print(val + " ");
             }
             System.out.println();

         }}


