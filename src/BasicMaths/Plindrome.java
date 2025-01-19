package BasicMaths;

import java.util.Scanner;

public class Plindrome {
    public boolean pal(int n){
        int original = n;
        int res;
        int copy;
        int rev=0;
        while(n>0){
             res = n%10;
             rev = rev*10+res;
            n=n/10;
        }
       return rev==original;



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Plindrome c = new Plindrome();
        boolean res = c.pal(N);
        if(res){
            System.out.println("pal");
        }
        else
            System.out.println("not");
    }
}
