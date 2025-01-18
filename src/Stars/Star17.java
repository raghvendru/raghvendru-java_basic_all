//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//    A
//   ABA
//  ABCBA
// ABCDCBA
//ABCDEDCBA

package Stars;

import java.util.Scanner;

public class Star17 {
    public void pat(int N) {
        for (int i = 0; i < N; i++) {
            // Print leading spaces
            for (int j = 1; j <= N - i - 1; j++) {
                System.out.print(" ");
            }

            char ch = 'A';
            // Print increasing characters
            for (int j = 0; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }

            // Adjust `ch` to decrement from the last printed character
            ch -= 2;

            // Print decreasing characters
            for (int j = 0; j < i; j++) {
                System.out.print(ch);
                ch--;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        Star17 s = new Star17();
        s.pat(N);
        sc.close();
    }
}
