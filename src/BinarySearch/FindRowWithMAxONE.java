package BinarySearch;
import java.util.*;
public class FindRowWithMAxONE {
        private int lowerBound(int[] arr, int n, int x) {
            int low = 0, high = n - 1;
            int ans = n;
            while (low <= high) {
                int mid = (low + high) / 2;
            /* If element at mid is greater than or equal
            to x then it counld be a possible answer.*/
                if (arr[mid] >= x) {
                    ans = mid;
                    // Look for smaller index on the left
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Return the answer
            return ans;
        }
        public int rowWithMax1s(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
        /* Variable to store the
        maximum count of 1's found*/
            int cnt_max = 0;
        /* Variable to store the index
        of the row with max 1's*/
            int index = -1;
            // Traverse each row of the matrix
            for (int i = 0; i < n; i++) {
                // Get the number of 1's
                int cnt_ones = m - lowerBound(mat[i], m, 1);
                if (cnt_ones > cnt_max) {
                    cnt_max = cnt_ones;
                    index = i;
                }
            }
            return index;
        }
        public static void main(String[] args) {
            int[][] matrix = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
            FindRowWithMAxONE sol = new FindRowWithMAxONE();
            System.out.println("The row with maximum number of 1's is: " +
                    sol.rowWithMax1s(matrix));
        }
    }
