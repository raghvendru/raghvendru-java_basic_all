package Stackandqueue;
import java.util.*;
public class SumOfSubarrayMinimals {
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        // Start traversing from the back
        for (int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];
            /* Pop the elements in the stack until
            the stack is not empty and the top
            element is not the smaller element */
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : n;
            /* Push the index of current
            element in the stack */
            st.push(i);
        }
        // Return the answer
        return ans;
    }
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currEle = arr[i];
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int n = arr.length;
        int mod = (int)1e9 + 7; // Mod value
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        SumOfSubarrayMinimals sol = new SumOfSubarrayMinimals();
        int ans = sol.sumSubarrayMins(arr);
        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}

