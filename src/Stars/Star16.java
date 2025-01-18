
//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//A
//BB
//CCC
//DDDD
//EEEEE
package Stars;

import java.util.Scanner;

public class Star16 {
    public void pat(int N) {
        for (int i = 0; i <N; i++) {
            char ch = (char) ('A' + i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star16 s = new Star16();
        s.pat(N);
    }
}
