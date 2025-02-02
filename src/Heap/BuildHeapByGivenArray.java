package Heap;
import java.util.*;

public class BuildHeapByGivenArray {
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

    // Function to convert given array into a min-heap
    public void buildMinHeap(int[] nums) {
        int n = nums.length;

        // Iterate backwards on the non-leaf nodes
        for (int i = n / 2 - 1; i >= 0; i--) {
            // Heapify each node downwards
            heapifyDown(nums, i);
        }

        return;
    }

    // Main method
    public static void main(String[] args) {
        int[] nums = {6, 5, 2, 7, 1, 7};
        System.out.println("Input array: " + Arrays.toString(nums));
        BuildHeapByGivenArray sol = new BuildHeapByGivenArray();
        sol.buildMinHeap(nums);
        System.out.println("Min-heap array: " + Arrays.toString(nums));
    }
}