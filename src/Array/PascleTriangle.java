package Array;
import java.util.*;
public class PascleTriangle {
    // Function to calculate nCr (combinations)
        private int nCr(int n, int r) {
            /* Choosing the smaller value
           of r to optimize computation */
            if (r > n - r) {
                r = n - r;
            }
            long res = 1;
        /* Calculate nCr using iterative
           method to avoid overflow */
            for (int i = 0; i < r; i++) {
                res = res * (n - i);
                res = res / (i + 1);
            }
            return (int)res;
        }
        // Function to generate Pascal's Triangle up to numRows rows
        public List<List<Integer>> pascalTriangle(int numRows) {
            // Initialize the triangle list with numRows lists
            List<List<Integer>> triangle = new ArrayList<>();
            // Fill the triangle with Pascal's Triangle values
            for (int i = 0; i < numRows; i++) {
                /* Create a new row list and
            resize it to i + 1 elements*/
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    //Compute and store value at position (i, j)
                    row.add(nCr(i, j));
                }
                triangle.add(row);
            }
            // Return completed Pascal's Triangle
            return triangle;
        }
        public static void main(String[] args) {
            int r = 5;
            int c = 3;
            PascleTriangle sol = new PascleTriangle();
            List<List<Integer>> pascalTriangle = sol.pascalTriangle(r);
            /* Check if column number is valid
           and retrieve the element at (r, c) */
            if (r >= c && c > 0) {
                int element = pascalTriangle.get(r - 1).get(c - 1);
                System.out.println("The element at position (" + r + "," + c + ") is: " + element);
            } else {
                // Print error message if column number is invalid
                System.out.println("Invalid column number!");
            }
        }
}
