package Stars;

import java.util.Scanner;

//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//*********
// *******
//  *****
//   ***
//    *
public class Star8 {
    public void pattern(int N){
//        for(int i=N;i>=1;i--){
//            //print spaces
//            for(int j=1;j<=N-i;j++){
//                System.out.print(" ");
//            }
//            //print *
//            for( int j =1;j<=2*i-1;j++){
//                System.out.print("*");
//            }
//
//            //print spaces
//            for( int j=1;j<=N-i;j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//
//        }
        //OR
        for (int i = 0;i<N;i++){
            //spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            //stars
            for(int j=0;j<(2*N)-(2*i)-1;j++){
                System.out.print("*");
            }

            //spaces
            for(int j=0;j<i;j++){
                System.out.print("");
            }
           System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star8 d = new Star8();
        d.pattern(N);
    }
}
