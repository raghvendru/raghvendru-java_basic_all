package BasicMaths;

import java.util.Scanner;

//Factorial of a given number
//100
//You are given an integer n. Return the value of n! or n factorial.
//Factorial of a number is the product of all positive integers less than or equal to that number.
public class Factorial {
    public int fact(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res = res*i;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Factorial c = new Factorial();
        int res = c.fact(N);
        System.out.println(res);
    }
}
