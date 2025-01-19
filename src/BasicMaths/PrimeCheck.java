package BasicMaths;
//Check for prime number
//100
//You are given an integer n. You need to check if the number is prime or not. Return true if it is a prime number, otherwise return false.
//A prime number is a number which has no divisors except 1 and itself.
public class PrimeCheck {
    /* Function to find whether the
       number is prime or not */
    public boolean isPrime(int n) {
//        if(n < 2) return false;
//        int count = 0;
//        for (int i = 1; i <= n; ++i) {
//            if (n % i == 0) {
//                count = count + 1;
//            }
//        }
//        if (count == 2) return true;
//        return false;
            if(n < 2) return false;
            int count = 0;
            for(int i = 1; i <= Math.sqrt(n); ++i) {
                if(n % i == 0) {
                    count = count + 1;
                    if(n % i != i) {
                        count = count + 1;
                    }
                }
            }
            if(count == 2) return true;
            return false;
    }

    public static void main(String[] args) {
        int n = 5;
        PrimeCheck sol = new PrimeCheck();
        boolean ans = sol.isPrime(n);
        if (ans) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
