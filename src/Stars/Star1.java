package Stars;

import java.util.Scanner;

public class Star1 {
    public void pattern(int N){
        for (int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                System.out.print("* ");
            }
            System.out.println(" ");

            }
        }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star1 s= new Star1();
        s.pattern(N);

    }
}
