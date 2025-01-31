package AdvancedMATHS;
import java.util.*;
public class CountPrimrInRangeLtoR {
        public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
            if (queries == null || queries.isEmpty()) {
                return new ArrayList<>();
            }
            int maxVal = 0;
            for (int[] query : queries) {
                maxVal = Math.max(maxVal, query[1]);
            }
            boolean[] isPrime = new boolean[maxVal + 1];
            for (int i = 2; i <= maxVal; i++) {
                isPrime[i] = true;
            }
            for (int p = 2; p * p <= maxVal; p++) {
                if (isPrime[p]) {
                    for (int i = p * p; i <= maxVal; i += p) {
                        isPrime[i] = false;
                    }
                }
            }
            int[] primeCount = new int[maxVal + 1];
            for (int i = 1; i <= maxVal; i++) {
                primeCount[i] = primeCount[i - 1];
                if (isPrime[i]) {
                    primeCount[i]++;
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int[] query : queries) {
                int start = query[0];
                int end = query[1];
                if (start == 0) {
                    result.add(primeCount[end]);
                } else {
                    result.add(primeCount[end] - primeCount[start - 1]);
                }
            }
            return result;
        }
    public static void main(String[] args) {
        // Example usage:
        ArrayList<int[]> queries = new ArrayList<>();
        queries.add(new int[]{2, 5});
        queries.add(new int[]{4, 7});
        CountPrimrInRangeLtoR solution = new CountPrimrInRangeLtoR();
        System.out.println(solution.primesInRange(queries)); // Output: [3, 2]
    }
    }

