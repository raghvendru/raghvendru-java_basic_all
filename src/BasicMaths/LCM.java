package BasicMaths;
///LCM of two numbers
/// 100
/// You are given two integers n1 and n2. You need find the Lowest Common Multiple (LCM) of the two given numbers. Return the LCM of the two numbers.
/// The Lowest Common Multiple (LCM) of two integers is the lowest positive integer that is divisible by both the integers.
public class LCM {
    public int LCM(int n1, int n2) {
//        int lcm;
//        int n = Math.max(n1, n2);
//        int i = 1;
//        while (true) {
//            int mul = n * i;
//            if (mul % n1 == 0 && mul % n2 == 0) {
//                lcm = mul;
//                break;
//            }
//            i++;
//        }
//        return lcm;
        int gcd = GCD(n1, n2);
        int lcm = (n1 * n2) / gcd;
        return lcm;
    }
    private int GCD(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 == 0) return n2;
            return n1;
        }
        return n1;
    }
    public static void main(String[] args) {
        int n1 = 4, n2 = 6;
        LCM sol = new LCM();
        int ans = sol.LCM(n1, n2);
        System.out.println("The LCM of " + n1 + " and " + n2 + " is: " + ans);
    }
}
