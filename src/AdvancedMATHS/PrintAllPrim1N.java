package AdvancedMATHS;
import java.util.ArrayList;

public class PrintAllPrim1N {
    class Solution {
        // Function to get all primes till N
        public ArrayList<Integer> primeTillN(int n) {

        /* To store whether a number is prime or not
        where all numbers are marked as prime initially */
            boolean[] isPrime = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                isPrime[i] = true;
            }

            // To store the prime numbers till N
            ArrayList<Integer> ans = new ArrayList<>();

            // Traverse from number 2 till N
            for (long i = 2; i <= n; i++) {

                // If the number is prime
                if (isPrime[(int) i]) {
                    // Store the number in the result
                    ans.add((int) i);

                    // Mark all its multiples as not prime
                    for (long val = i * i; val <= n; val += i) {

                        // Marking multiples of i as not prime
                        isPrime[(int) val] = false;
                    }
                }
            }
            // Return the result
            return ans;
        }

    }
        }

