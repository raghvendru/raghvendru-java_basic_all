package Heap;

public class HeapSort {
    private void heapifyDown(int[] arr, int last, int ind) {
        int largestInd = ind;
        int leftChildInd = 2 * ind + 1, rightChildInd = 2 * ind + 2;
        if(leftChildInd <= last && arr[leftChildInd] > arr[largestInd]) {
            largestInd = leftChildInd;
        }
        if(rightChildInd <= last && arr[rightChildInd] > arr[largestInd]) {
            largestInd = rightChildInd;
        }
        if(largestInd != ind) {
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;
            heapifyDown(arr, last, largestInd);
        }
        return;
    }
    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            // Heapify each node downwards
            heapifyDown(nums, n - 1, i);
        }
        return;
    }

    public void heapSort(int[] nums) {
        buildMaxHeap(nums);

        int last = nums.length - 1;

        // Until there are elements left to sort in the array
        while(last > 0) {
            // Swap the greatest element to the current last index
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            last--; // Decrement the last index

            if(last > 0) {
                // Heapify down the root
                heapifyDown(nums, last, 0);
            }
        }

        return;
    }
    public static void main(String[] args) {
        int[] nums = {60, 30, 40, 20, 10, 50};
        System.out.print("Input Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
        HeapSort sol = new HeapSort();
        sol.heapSort(nums);
        System.out.print("\nSorted Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
    }
}

