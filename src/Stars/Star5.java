package Stars;//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//        *****
//        ****
//        ***
//        **
//        *

import java.util.Scanner;

public class Star5 {
    public void pattern(int N){
        for (int i=N;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println(" ");

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star5 s= new Star5();
        s.pattern(N);

    }
}
