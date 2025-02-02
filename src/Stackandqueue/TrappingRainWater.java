package Stackandqueue;

public class TrappingRainWater {
    public int trap(int[] height) {

        int n = height.length; // Size of array

        // To store the total trapped rainwater
        int total = 0;

        // To store the maximums on both sides
        int leftMax = 0, rightMax = 0;

        // Left and Right pointers
        int left = 0, right = n - 1;

        // Traverse from both ends
        while (left < right) {

            // If left height is smaller or equal
            if (height[left] <= height[right]) {

                // If water can be stored
                if (leftMax > height[left]) {

                    // Update total water
                    total += leftMax - height[left];
                }

                // Else update maximum height on left
                else leftMax = height[left];

                // Shift left by 1
                left = left + 1;
            }

            // Else if right height is smaller
            else {

                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                }
                else rightMax = height[right];

                // Shift right by 1
                right = right - 1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        TrappingRainWater sol = new TrappingRainWater();
        int ans = sol.trap(heights);
        System.out.println("The trapped rainwater is: " + ans);
    }
}
