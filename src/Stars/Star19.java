package Stars;
//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//**********
//****  ****
//***    ***
//**      **
//*        *
//*        *
//**      **
//***    ***
//****  ****
//**********
class Star19 {
    // Function to print pattern19
    public void pattern19(int n) {
        // Print the upper half pattern

        // Store the initial spaces.
        int iniS = 0;

        for (int i = 0; i < n; i++) {
            // Printing the stars in the row.
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }

            // Printing the spaces in the row.
            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }

            // Printing the stars in the row.
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }

            /* The spaces increase by 2
            every time we hit a new row. */
            iniS += 2;

            // Give a line break for a new row.
            System.out.println();
        }

        // Print the lower half pattern

        // Store the initial spaces.
        iniS = 2 * n - 2;

        for (int i = 1; i <= n; i++) {
            // Printing the stars in the row.
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Printing the spaces in the row.
            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }

            // Printing the stars in the row.
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            /* The spaces decrease by 2
            every time we hit a new row. */
            iniS -= 2;

            // Give a line break for a new row.
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int N = 5;

        // Create an instance of Solution class
        Star19 sol = new Star19();

        sol.pattern19(N);
    }

}
