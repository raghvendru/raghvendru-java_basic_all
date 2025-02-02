package Heap;

public class ConvertMinToMaxHeap {
    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; // Size of the array

        // To store the index of largest element
        int largestInd = ind;

        // Indices of the left and right children
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;

        // If the left child holds larger value, update the largest index
        if(leftChildInd < n && arr[leftChildInd] > arr[largestInd]) {
            largestInd = leftChildInd;
        }

        // If the right child holds larger value, update the largest index
        if(rightChildInd < n && arr[rightChildInd] > arr[largestInd]) {
            largestInd = rightChildInd;
        }

        // If the largest element index is updated
        if(largestInd != ind) {
            // Swap the largest element with the current index
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, largestInd);
        }
    }
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        // Iterate backwards on the non-leaf nodes
        for(int i = n/2 - 1; i >= 0; i--) {
            // Heapify each node downwards to ensure max-heap property
            heapifyDown(nums, i);
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};
        System.out.print("Initial Min-heap Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
        ConvertMinToMaxHeap sol = new ConvertMinToMaxHeap();
        nums = sol.minToMaxHeap(nums);
        System.out.print("\nMax-heap converted Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
    }
}

