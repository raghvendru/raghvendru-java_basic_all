//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//         *
//        ***
//       *****
//      *******
//     *********
import java.util.Scanner;

public class Star7 {
    public void pattern(int N){
        for (int i=1;i<=N;i++){
            int k=0;
            for(int j=1+k;j<=i;j++){
                System.out.print(j);
                k++;
            }
            System.out.println(" ");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star7 s = new Star7();
        s.pattern(N);
    }
}
