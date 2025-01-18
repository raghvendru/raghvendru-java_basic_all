package Stars;//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//         *
//        ***
//       *****
//      *******
//     *********
import java.util.Scanner;

public class Star7 {
    //spaces ,stars,spaces
    public void pattern(int N){
        for(int i=1;i<=N;i++){
            //print spaces
            for(int j=1;j<=N-i;j++){
                System.out.print(" ");
            }
            //print *
            for( int j =1;j<=2*i-1;j++){
                System.out.print("*");
            }

            //print spaces
            for( int j=1;j<=N-i;j++){
                System.out.print(" ");
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star7 d = new Star7();
        d.pattern(N);
    }
}
