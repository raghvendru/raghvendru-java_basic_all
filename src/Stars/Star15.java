package Stars;

import java.util.Scanner;

//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//ABCDE
//ABCD
//ABC
//AB
//A
public class Star15 {
    public void pat(int N) {
        for (int i = N-1; i >=0; i--) {
            for (char ch = 'A'; ch <='A' + i; ch++) {
                System.out.print(ch + " ");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star15 s = new Star15();
        s.pat(N);
    }
}
