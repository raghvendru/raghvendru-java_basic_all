package BasicMaths;
//You are given an integer n. Return the integer formed by placing the digits of n in reverse order.
//        Examples:
//Input: n = 25
//Output: 52


import java.util.Scanner;

public class ReverNo {
    public int rev(int n){
        int rev=0;
        while(n>0){
           int rem = n%10;
           rev = rev*10+rem;
           n=n/10;
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ReverNo c = new ReverNo();
        int res = c.rev(N);
        System.out.println(res);
    }
}
