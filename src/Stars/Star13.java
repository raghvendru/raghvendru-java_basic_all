package Stars;

import java.util.Scanner;

//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//1
//2 3
//4 5 6
//7 8 9 10
//11 12 13 14 15
public class Star13 {
    public void pat(int N){
        int num = 1;
        for(int i=1;i<=N;i++){

            for(int j=1;j<=i;j++){
                System.out.print(num+" ");
                num = num+1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star13 s = new Star13();
        s.pat(N);
    }
}
