package BasicMaths;
//GCD of two numbers
//You are given two integers n1 and n2. You need find the Greatest Common Divisor (GCD) of the two given numbers. Return the GCD of the two numbers.
//The Greatest Common Divisor (GCD) of two integers is the largest positive integer that divides both of the integers.
//Examples:
//Input: n1 = 4, n2 = 6
//Output: 2
//Explanation: Divisors of n1 = 1, 2, 4, Divisors of n2 = 1, 2, 3, 6
//Greatest Common divisor = 2.

public class GCDorHCF {
    public int GCD(int n1, int n2) {
        //optimal
//        int gcd = 1;
//        for(int i = 1; i <= Math.min(n1, n2); i++) {
//            if(n1 % i == 0 && n2 % i == 0) {
//                gcd = i;
//            }
//        }
//        return gcd;

        //better
//        int gcd = 1;
//        for (int i = Math.min(n1, n2); i >= 1; --i) {
//            if (n1 % i == 0 && n2 % i == 0) {
//                gcd = i;
//                break;
//            }
//        }
//        return gcd;

        //optimal
//        while (n1 > 0 && n2 > 0) {
//            if (n1 > n2) {
//                n1 = n1 % n2;
//            }
//            else {
//                n2 = n2 % n1;
//            }
//        }
//        if (n1 == 0) return n2;
//        return n1;
        while(n1>0&&n2>0){
            if(n1>n2){
                n1=n1-n2;
            }
            else n2=n2-n1;
        }
        if(n2==0) return n2;
        else return  n1;
    }
    public static void main(String[] args) {
        int n1 = 4, n2 = 6;
        GCDorHCF sol = new GCDorHCF();
        int ans = sol.GCD(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + ans);
    }
}
