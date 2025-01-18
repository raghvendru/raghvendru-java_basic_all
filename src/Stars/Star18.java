package Stars;
//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

//E
//D E
//C D E
//B C D E
//A B C D E
class Star18 {
    // Function to print pattern18
    public void pattern18(int n) {
        // Outer loop for the number of rows.
        for (int i = 0; i < n; i++) {

            /* Inner loop for printing alphabets
            from A + n -1 -i (i is row no.) to
            A + n -1 ( E in this case).*/
            for(char ch = (char)(('A'+ n-1)-i); ch <= ('A'+ n-1); ch++){
                System.out.print(ch+" ");
            }

            // Move to the next line for the next row.
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int N = 5;

        //Create an instance of Solution class
        Star18 sol = new Star18();

        sol.pattern18(N);
    }

}
