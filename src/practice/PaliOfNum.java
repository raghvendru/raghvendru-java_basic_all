package practice;

import java.util.Scanner;

public class PaliOfNum {
    public boolean pal(int n){
        int cpy = n;
        int rev = 0;
        while(n>0){
           int rem = n%10;
           rev = rev*10+rem;
           n = n/10;
        }
        return rev == cpy;
    }

    public static void main(String[] args) {
        PaliOfNum p = new PaliOfNum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean ans = p.pal(n);
        if(ans){
            System.out.printf("%d is pal",n);
        }else{
            System.out.printf("%d not pal",n);
        }
    }
}
