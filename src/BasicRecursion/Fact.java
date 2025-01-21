package BasicRecursion;

public class Fact{

    public long factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n <= 1) return 1;
        // Recursive case: n * factorial of n-1
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Fact solution = new Fact();
        int N = 5; // Example input
        System.out.println("Factorial of " + N + " is " + solution.factorial(N));
    }
}
