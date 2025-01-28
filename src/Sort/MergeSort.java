package Sort;
import java.util.ArrayList;
import java.util.List;
//Divide and merge
public class MergeSort {
    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        mergeSortHelper(nums, 0, n - 1);
        return nums;
    }
    public void mergeSortHelper(int[] arr, int low, int high) {
        if(low == high) return;
        int mid = (low + high) / 2;
        mergeSortHelper(arr, low, mid);
        mergeSortHelper(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
         nums[i] = temp.get(i-low);
        }

    }
    public static void main(String[] args) {
        int[] a = {13,9,4,24,52,6,90};
        MergeSort s = new MergeSort();
        int[] ans = s.mergeSort(a);
        for(int num:ans) {
            System.out.print(num+" ");
        }

    }
}
