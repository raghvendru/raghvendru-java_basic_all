package Heap;
import java.util.*;
public class HeapifyAlgo {
    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; // Size of the array
        // Index of largest element
        int largest_Ind = ind;
        // Indices of the left and right children
        int leftChild_Ind = 2 * ind + 1, rightChild_Ind = 2 * ind + 2;
        // If the left child holds a larger value, update the largest index
        if (leftChild_Ind < n && arr[leftChild_Ind] < arr[largest_Ind])
            largest_Ind = leftChild_Ind;
        // If the right child holds a larger value, update the largest index
        if (rightChild_Ind < n && arr[rightChild_Ind] < arr[largest_Ind])
            largest_Ind = rightChild_Ind;
        // If the largest element index is updated
        if (largest_Ind != ind) {
            // Swap the largest element with the current index
            int temp = arr[largest_Ind];
            arr[largest_Ind] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, largest_Ind);
        }
        return;
    }
    // Function to recursively heapify the array upwards
    private void heapifyUp(int[] arr, int ind) {
        int parent_Ind = (ind - 1) / 2;
        // If current index holds a greater value than the parent
        if (ind > 0 && arr[ind] < arr[parent_Ind]) {
            // Swap the values at the two indices
            int temp = arr[ind];
            arr[ind] = arr[parent_Ind];
            arr[parent_Ind] = temp;

            // Recursively heapify the upper nodes
            heapifyUp(arr, parent_Ind);
        }
        return;
    }
    public void heapify(int[] nums, int ind, int val) {
        // If the current value is replaced with a smaller value
        if (nums[ind] > val) {
            nums[ind] = val;
            heapifyUp(nums, ind);
        }
        else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }

        return;
    }
}
class Main {
    // Main method
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 5, 7, 6};
        int ind = 5, val = 2;
        System.out.println("Input array: " + Arrays.toString(nums));
        HeapifyAlgo sol = new HeapifyAlgo();
        sol.heapify(nums, ind, val);
        System.out.println("Modified array after heapifying: " + Arrays.toString(nums));
    }
}