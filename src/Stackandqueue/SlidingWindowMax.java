package Stackandqueue;
import java.util.*;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length; // Size of array

        // To store the answer
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;

        // Deque data structure
        Deque<Integer> dq = new LinkedList<>();

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Update deque to maintain current window
            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }

            /* Maintain the monotonic (decreasing)
            order of elements in deque */
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // Add current element's index to the deque
            dq.offerLast(i);

            /* Store the maximum element from
            the first window possible */
            if (i >= (k - 1)) {
                ans[ansIndex++] = arr[dq.peekFirst()];
            }
        }

        // Return the stored result
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        /* Creating an instance of
        Solution class */
        SlidingWindowMax sol = new SlidingWindowMax();

        /* Function call to get the
        maximum sliding window */
        int[] ans = sol.maxSlidingWindow(arr, k);

        System.out.print("The maximum elements in the sliding window are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

