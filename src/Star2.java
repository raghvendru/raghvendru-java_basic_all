import java.util.Scanner;

//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//        *
//        **
//        ***
//        ****
//        *****
public class Star2 {
    public void pattern(int N){
        for (int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println(" ");

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star2 s= new Star2();
        s.pattern(N);

    }
}
