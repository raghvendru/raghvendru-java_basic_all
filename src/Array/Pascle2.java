package Array;

public class Pascle2 {

        // Function to calculate nCr (combinations)
        private long nCr(int n, int r) {
            long res = 1;

            // Calculate nCr:
            for (int i = 0; i < r; i++) {
                res = res * (n - i);
                res = res / (i + 1);
            }
            return res;
        }

        /* Function to print Pascal's
        Triangle row for given n */
        public void generate(int n) {

        /* Print the entire row of
        Pascal's Triangle for row n: */
            for (int c = 1; c <= n; c++) {
                System.out.print(nCr(n - 1, c - 1) + " ");
            }

            System.out.println();
        }


}
