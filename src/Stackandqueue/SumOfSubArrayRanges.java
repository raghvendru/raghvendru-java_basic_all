package Stackandqueue;
import java.util.*;

public class SumOfSubArrayRanges {
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }
    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
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
    private int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currEle = arr[i];
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }
    private long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val = (freq * arr[i] * 1L);
            sum += val;
        }
        return sum;
    }
    private long sumSubarrayMaxs(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = left * right * 1L;
            long val = (freq * arr[i] * 1L);
            sum += val;
        }
        return sum;
    }
    public long subArrayRanges(int[] arr) {
        return ( sumSubarrayMaxs(arr) -
                sumSubarrayMins(arr) );
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        SumOfSubArrayRanges sol = new SumOfSubArrayRanges();
        long ans = sol.subArrayRanges(arr);
        System.out.println("The sum of subarray ranges is: " + ans);
    }
}
