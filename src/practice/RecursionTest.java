package practice;

public class RecursionTest {

    public static void print1ToN(int i, int n) {
        if (i > n) return;
        print1ToN(i + 1, n); // recursive call before printing
        System.out.print(i + " "); // print after recursion call
    }

    public static void main(String[] args) {
        int n = 5;
        // Printing 1 to N
        print1ToN(1, n);
    }
}
