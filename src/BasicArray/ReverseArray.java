package BasicArray;
//Reverse an array
//100
//Given an array arr of n elements. The task is to reverse the given array. The reversal of array should be inplace.
//Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]
public class ReverseArray {
    public void reverse(int arr[], int n) {
//        int[] ans = new int[n];
//        for (int i = n - 1; i >= 0; i--) {
//            ans[n - i - 1] = arr[i];
//        }
//        for(int i = 0; i < n; i++) {
//            arr[i] = ans[i];
//        }
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
        }
        // Return
        return;
    }
}

class Main {
    // Function to print array
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5, 4, 3, 2, 1};
        // Creating instance of Solution class
        ReverseArray solution = new ReverseArray();
        System.out.print("Original array: ");
        printArray(arr, n);
        // Function call to reverse the array
        solution.reverse(arr, n);
        System.out.print("Reversed array: ");
        printArray(arr, n);
    }
}
