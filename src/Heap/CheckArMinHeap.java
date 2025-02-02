package Heap;

public class CheckArMinHeap {
    public boolean isHeap(int[] nums) {
        int n = nums.length; // Size of the array

        // Iterate on the non-leaf nodes from the back
        for(int i = n/2 - 1; i >= 0; i--) {
            int leftChildInd = 2 * i + 1;
            int rightChildInd = 2 * i + 2;

            // If left child has a smaller value than the parent
            if(leftChildInd < n && nums[leftChildInd] < nums[i])
                return false;

            // If right child has a smaller value than parent
            if(rightChildInd < n && nums[rightChildInd] < nums[i])
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};

        System.out.print("Given Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }

        // Creating an object of the Solution class
        CheckArMinHeap sol = new CheckArMinHeap();

        // Function call to check if the given array is a min-heap
        boolean ans = sol.isHeap(nums);

        if(ans)
            System.out.println("\nThe given array is a min-heap.");
        else
            System.out.println("\nThe given array is not a min-heap.");

    }
}

