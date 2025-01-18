package Stars;//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//A
//AB
//ABC
//ABCD
//ABCDE

import java.util.Scanner;

public class Star14 {
    public void pat(int N) {
        for (int i = 0; i < N; i++) {
            for (char ch = 'A'; ch <='A' + i; ch++) {
                System.out.print(ch + " ");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star14 s = new Star14();
        s.pat(N);
    }
}
