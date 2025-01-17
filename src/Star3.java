//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//        1
//        12
//        123
//        1234
//        12345


import java.util.Scanner;

public class Star3 {
    public void pattern(int N){
        for (int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println(" ");

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star3 s= new Star3();
        s.pattern(N);

    }
}
