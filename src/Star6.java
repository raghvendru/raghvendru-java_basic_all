//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//        12345
//        1234
//        123
//        12
//        1

import java.util.Scanner;

public class Star6 {
    public void pattern(int N){
        for (int i=N;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println(" ");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star6 s = new Star6();
        s.pattern(N);
    }
}
