package AdvancedRecursion;

public class Powxn {
    class Solution {
        private double power(double x, long n) {
            // Base case: anything raised to 0 is 1
            if (n == 0) return 1.0;
            // Base case: anything raised to 1 is itself
            if (n == 1) return x;
            // If 'n' is even
            if (n % 2 == 0) {
                // Recursive call: x * x, n / 2
                return power(x * x, n / 2);
            }
            // If 'n' is odd
            // Recursive call: x * power(x, n - 1)
            return x * power(x, n - 1);
        }
        public double myPow(double x, int n) {
            // If 'n' is negative
            if (n < 0) {
                // Calculate the power of -n and take reciprocal
                return 1.0 / power(x, -n);
            }
            // If 'n' is non-negative
            return power(x, n);
        }

        public static void main(String[] args) {
            Powxn p = new Powxn();
            Solution sol = p.new Solution();
            double x = 2.0;
            int n = 10;
            double result = sol.myPow(x, n);
            System.out.println(x + "^" + n + " = " + result);
        }
    }

}
