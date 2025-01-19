package BasicMaths;

import java.util.Scanner;

//Count number of odd digits in a number
//100
//You are given an integer n. You need to return the number of odd digits present in the number.
//The number will have no leading zeroes, except when the number is 0 itself.
public class CountNoOfOddDi {
    public int Count(int n){
        if(n==0) return 0;
        int c=0;
        while(n>0){
            int f = n%10;
            if(f%2 != 0){
                 c++;
            }
            n=n/10;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CountNoOfOddDi c = new CountNoOfOddDi();
        int res = c.Count(N);
        System.out.println(res);
    }
}
