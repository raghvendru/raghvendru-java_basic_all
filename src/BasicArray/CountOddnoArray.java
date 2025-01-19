package BasicArray;
//Count of odd numbers in array
//100
//Given an array of n elements. The task is to return the count of the number of odd in the array.
//Examples:
//Input: n=5, array = [1,2,3,4,5]
//Output: 3
//Explanation: The three odd elements are (1,3,5).
public class CountOddnoArray {
    public int countOdd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        CountOddnoArray sol = new CountOddnoArray();
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int count = sol.countOdd(arr, n);
        System.out.println("Count of odd numbers: " + count);
    }
}
