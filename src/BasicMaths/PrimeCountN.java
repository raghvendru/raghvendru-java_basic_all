package BasicMaths;
//Count of prime numbers till N
//100
//You are given an integer n. You need to find out the number of prime numbers in the range [1, n] (inclusive). Return the number of prime numbers in the range.
//A prime number is a number which has no divisors except, 1 and itself.
public class PrimeCountN {
    private boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                count = count + 1;
            }
        }
        if (count == 2) return true;
        // Else not prime
        return false;
    }
    public int primeUptoN(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        PrimeCountN sol = new PrimeCountN();
        int ans = sol.primeUptoN(n);
        System.out.println("The count of primes till " + n + " is: " + ans);
    }
}
