package BasicMaths;

import java.util.Scanner;

//You are given an integer n. You need to return the number of digits in the number.
//The number will have no leading zeroes, except when the number is 0 itself.
public class CountAllDigits {
    public int Count(int n){
        int count = 0;
        if(n==0) return 1;

        while(n>0){
            int fd = n%10;
            count++;
            n=n/10;
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CountAllDigits c = new CountAllDigits();
        int res = c.Count(N);
        System.out.println(res);
    }
}
