package Stars;//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//1
//0 1
//1 0 1
//0 1 0 1
//1 0 1 0 1
//Print the pattern in the function given to you.

import java.util.Scanner;

public class Star11 {
    public void pat(int N){
        for(int i=1;i<=N;i++){
            int start = 1;
            if(i%2==0) start=0;
            for(int j=1;j<=i;j++){
                System.out.print(start + " ");
                start=1-start;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        Star11 s = new Star11();
        s.pat(N);
    }
}
