package BasicRecursion;

public class RevArray1 {
    public int[] reverseArray(int[] nums) {
        // Call the helper function to reverse the array
        reverse(nums, 0, nums.length - 1);
        // Return the reversed array
        return nums;
    }

    private void reverse(int[] nums, int left, int right) {
        // Base case: pointers have crossed, the array is reversed
        if (left >= right) {
            return;
        }
        // Swap the elements
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        // Recursive call with updated pointers
        reverse(nums, left + 1, right - 1);
    }


    // Main method for testing the reverseArray function
    public static void main(String[] args) {
        RevArray1 solution = new RevArray1();
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = solution.reverseArray(nums);
        for (int num : result) {
            System.out.print(num + " ");

        }
    }
}

