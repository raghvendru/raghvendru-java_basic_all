package Array;
import java.util.*;
public class Pascle3 {
        /* Function to generate a single
        row of Pascal's Triangle*/
        private List<Integer> generateRow(int row) {
            long ans = 1;
            List<Integer> ansRow = new ArrayList<>();
            // Inserting the 1st element
            ansRow.add(1);

            // Calculate the rest of the elements
            for (int col = 1; col < row; col++) {
                ans = ans * (row - col);
                ans = ans / col;
                ansRow.add((int) ans);
            }
            return ansRow;
        }
        /* Function to generate Pascal's
        Triangle up to n rows*/
        public List<List<Integer>> generate(int n) {
            List<List<Integer>> pascalTriangle = new ArrayList<>();

            // Store the entire Pascal's Triangle
            for (int row = 1; row <= n; row++) {
                pascalTriangle.add(generateRow(row));
            }

            // Return the Pascal's Triangle
            return pascalTriangle;
        }
        public static void main(String[] args) {
            int n = 5;
            Pascle3 sol = new Pascle3();

            // Generate Pascal's Triangle with n rows
            List<List<Integer>> pascalTriangle = sol.generate(n);

            // Output the Pascal's Triangle
            for (List<Integer> row : pascalTriangle) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }


}
