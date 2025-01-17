import java.util.Scanner;

//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//        1
//        22
//        333
//        4444
//        55555
public class Star4 {
    public void pattern(int N){
        for (int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println(" ");

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star4 s= new Star4();
        s.pattern(N);

    }
}
