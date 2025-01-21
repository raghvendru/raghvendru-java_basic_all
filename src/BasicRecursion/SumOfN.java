package BasicRecursion;

public class SumOfN {
    public int NnumbersSum(int N) {
        // Base case: if N is 0, return 0
        if (N == 0) return 0;
        // Recursive case: add N to the sum of N-1
        return N + NnumbersSum(N - 1);
    }

    public static void main(String[] args) {
        SumOfN solution = new SumOfN();
        int N = 10; // Example input
        System.out.println("Sum of first " + N + " numbers is " + solution.NnumbersSum(N));
    }
}


