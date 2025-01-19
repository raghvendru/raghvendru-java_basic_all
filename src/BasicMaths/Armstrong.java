package BasicMaths;
import java.util.Scanner;//Check if the number is armstrong
//100
//You are given an integer n. You need to check whether it is an armstrong number or not. Return true if it is an armstrong number, otherwise return false.
//An armstrong number is a number which is equal to the sum of the digits of the number, raised to the power of the number of digits.
//Input: n = 153
//Output: true
//Explanation: Number of digits : 3.
//1 ^ 3 + 5 ^ 3 + 3 ^ 3 = 1 + 125 + 27 = 153.
//Therefore, it is an Armstrong number.
public class Armstrong {
    public int count(int n) {
        int cnt = 0;
        if (n == 0) return 1;
        while (n > 0) {
            int rem = n % 10;
            cnt++;
            n = n / 10;
        }
        return cnt;
    }
    public boolean arm(int n) {
        int res = 0;
        int cpy=n;
        int count = count(n);
        while (n > 0) {
            int reminder = n % 10;
            res += (int) Math.pow(reminder, count);
            n = n / 10;
        }
        if(res==cpy) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Armstrong c = new Armstrong();
        boolean res = c.arm(N);
        System.out.println(res);
        if(res) System.out.println("arm");
        else System.out.println("not arm");
    }

    }


