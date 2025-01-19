package BasicMaths;
//Return the largest digit in a number
//You are given an integer n. Return the largest digit present in the number.
//Examples:
//Input: n = 25
//Output: 5

import java.util.Scanner;

public class LArgestNo {
    public int lar(int n){
        if(n==0) return 0;
        int min = Integer.MIN_VALUE;
        while (n>0){
            int res = n%10;
            if(res>min){
                min = res;
            }
            n=n/10;
        }
        return  min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LArgestNo c = new LArgestNo();
        int res = c.lar(N);
        System.out.println(res);
    }
}
