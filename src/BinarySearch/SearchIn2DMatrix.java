package BinarySearch;
import java.util.*;

public class SearchIn2DMatrix {
        public boolean searchMatrix(int[][] mat, int target) {
            int n = mat.length;
            int m = mat[0].length;
            int low = 0, high = n * m - 1;
            // Perform binary search
            while (low <= high) {
                int mid = (low + high) / 2;
                // Calculate the row and column
                int row = mid / m;
                int col = mid % m;
                // If target is found return true
                if (mat[row][col] == target) return true;
                else if (mat[row][col] < target) low = mid + 1;
                else high = mid - 1;
            }

            // Return false if target is not found
            return false;
        }

        public static void main(String[] args) {
            int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
            int target = 8;

            // Create an instance of Solution class
            SearchIn2DMatrix sol = new SearchIn2DMatrix();

            boolean result = sol.searchMatrix(matrix, target);

            // Output the result
            System.out.println(result ? "true" : "false");
        }

}


