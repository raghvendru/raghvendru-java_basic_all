package AdvancedMATHS;
import java.util.*;
public class PrimeFactorisation {
        private static final int MAX_N = 100000;
        private int[] SPF = new int[MAX_N + 1];
        public PrimeFactorisation() {
            Arrays.fill(SPF, 1);
        }
        private void sieve() {
            // Iterate on all the number
            for (int i = 2; i <= MAX_N; i++) {
                // If the number is a prime number
                if (SPF[i] == 1) {
                    for (int j = i; j <= MAX_N; j += i) {
                        // If smallest prime factor not received yet
                        if (SPF[j] == 1) {
                        /* Store i as the smallest
                        prime factor for its multiple */
                            SPF[j] = i;}
                    }
                }
            }
        }
        private List<Integer> primeFact(int n) {
            List<Integer> ans = new ArrayList<>();
            while (n != 1) {
                ans.add(SPF[n]);
                n = n / SPF[n];
            }
            return ans;
        }
        public List<List<Integer>> primeFactors(int[] queries) {
            sieve();
            List<List<Integer>> ans = new ArrayList<>();
            for (int query : queries) {
                ans.add(primeFact(query));
            }
            return ans;
        }
        public static void main(String[] args) {
            int[] queries = {2, 3, 4, 5, 6};
            PrimeFactorisation sol = new PrimeFactorisation();
            List<List<Integer>> ans = sol.primeFactors(queries);
            System.out.println("The prime factorization of all the numbers is: ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("For " + queries[i] + ": ");
                for (int factor : ans.get(i)) {
                    System.out.print(factor + " ");
                }
                System.out.println();
            }
        }
    }


