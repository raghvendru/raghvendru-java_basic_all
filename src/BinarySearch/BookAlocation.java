package BinarySearch;
import java.util.*;
public class BookAlocation {
        private int countStudents(int[] nums, int pages) {
            int n = nums.length;
            int students = 1;
            int pagesStudent = 0;
            for (int i = 0; i < n; i++) {
                if (pagesStudent + nums[i] <= pages) {
                    pagesStudent += nums[i];
                } else {
                    students++;
                    pagesStudent = nums[i];
                }
            }
            return students;
        }
        public int findPages(int[] nums, int m) {
            int n = nums.length;
            // Book allocation impossible
            if (m > n) return -1;
            // Calculate the range for search
            int low = Integer.MIN_VALUE;
            int high = 0;
            for(int i = 0; i < n; i++){
                low = Math.max(low, nums[i]);
                high = high + nums[i];
            }
            // Binary search for minimum maximum pages
            while (low <= high) {
                int mid = (low + high) / 2;
                int students = countStudents(nums, mid);
                if (students > m) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            return low;
        }
        public static void main(String[] args) {
            int[] arr = {25, 46, 28, 49, 24};
            int m = 4;
            BookAlocation sol = new BookAlocation();
            int ans = sol.findPages(arr, m);
            // Output the result
            System.out.println("The answer is: " + ans);
        }

}
