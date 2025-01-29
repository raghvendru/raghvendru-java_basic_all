package Array;
import java.util.*;
public class ReversePairs {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            return team(nums, n);}
        private void merge(int[] arr, int low, int mid, int high) {
            List<Integer> temp = new ArrayList<>();
            int left = low;
            int right = mid + 1;
            // Merge and count reverse pairs
            while (left <= mid && right <= high) {
                if (arr[left] <= arr[right]) {
                    temp.add(arr[left]);
                    left++;
                } else {
                    temp.add(arr[right]);
                    right++;
                }
            }// Copy remaining elements from left half
            while (left <= mid) {
                temp.add(arr[left]);
                left++;
            }// Copy remaining elements from right half
            while (right <= high) {
                temp.add(arr[right]);
                right++;
            }// Transfer sorted elements from temp to arr
            for (int i = low; i <= high; i++) {
                arr[i] = temp.get(i - low);
            }
        }
        // Function to count reverse pairs
        private int countPairs(int[] arr, int low, int mid, int high) {
            int right = mid + 1;
            int cnt = 0;
            for (int i = low; i <= mid; i++) {
                /*while right is less than equal to high and arr[i]
            is greater than 2 * arr[right] then increment right by 1*/
                while (right <= high && arr[i] > 2 * arr[right]) right++;

                cnt += (right - (mid + 1));
            }
            //Return the count
            return cnt;}
        private int mergeSort(int[] arr, int low, int high) {
            int cnt = 0;
            if (low >= high) {
                return cnt;
            }
            int mid = low + (high - low) / 2;
            // Sort left half
            cnt += mergeSort(arr, low, mid);
            // Sort right half
            cnt += mergeSort(arr, mid + 1, high);
            // Merge and count pairs
            cnt += countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);
            //Return the count of reverse pairs
            return cnt;
        }
        private int team(int[] skill, int n) {
            return mergeSort(skill, 0, n - 1);
        }

        public static void main(String[] args) {
            int[] nums = {6, 4, 1, 2, 7};
            // Create an instance of Solution class
            ReversePairs sol = new ReversePairs();
            int cnt = sol.reversePairs(nums);
            // Print the count of reverse pairs
            System.out.println("The number of reverse pairs is: " + cnt);
        }

}


