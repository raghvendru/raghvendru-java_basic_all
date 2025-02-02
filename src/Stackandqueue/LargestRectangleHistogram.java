package Stackandqueue;
import java.util.*;
public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; // Size of array
        Stack<Integer> st = new Stack<>();
        // To store largest area
        int largestArea = 0;

        // To store current area
        int area;
        int nse, pse;

        // Traverse on the array
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() &&
                    heights[st.peek()] >= heights[i]) {

                // Get the index of top of stack
                int ind = st.pop();

                /* Update the index of
                previous smaller element */
                pse = st.isEmpty() ? -1 : st.peek();

                /* Next smaller element index for
                the popped element is current index */
                nse = i;

                // Calculate the area of the popped element
                area = heights[ind] * (nse - pse - 1);

                // Update the maximum area
                largestArea = Math.max(largestArea, area);
            }
            // Push the current index in stack
            st.push(i);
        }
        // For elements that are not popped from stack
        while(!st.isEmpty()) {
            // NSE for such elements is size of array
            nse = n;
            // Get the index of top of stack
            int ind = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            area = heights[ind] * (nse - pse - 1);
            largestArea = Math.max(largestArea, area);
        }

        // Return largest area found
        return largestArea;
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        LargestRectangleHistogram sol = new LargestRectangleHistogram();
        int ans = sol.largestRectangleArea(heights);
        System.out.println("The largest rectangle area is: " + ans);
    }
}
