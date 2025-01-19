package BasicMaths;
//You are given an integer n. You need to check if the number is a perfect number or not. Return true if it is a perfect number, otherwise, return false.
//A perfect number is a number whose proper divisors add up to the number itself.
//Examples:
//Input: n = 6
//Output: true
//Explanation: Proper divisors of 6 are 1, 2, 3.
//1 + 2 + 3 = 6.
public class PerfectNo {
//        public boolean isPerfect(int n) {
//            int sum = 0;
//            for(int i = 1; i < n; ++i) {
//                if(n % i == 0){
//                    sum = sum + i;
//                }
//            }
//            if(sum == n) return true;
//            return false;
//        }

    public boolean isPerfect(int n) {
        if(n == 1) return false;
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                // Update sum
                sum = sum + i;
                if (n / i != n && i != n / i) {
                    sum = sum + (n / i);
                }
            }
        }
        if (sum == n) return true;
        return false;
    }
        public static void main(String[] args) {
        int n = 6;
        PerfectNo sol = new PerfectNo();
        boolean ans = sol.isPerfect(n);
        if(ans) {
            System.out.println(n + " is a perfect number.");
        } else {
            System.out.println(n + " is not a perfect number.");
        }
    }
}
