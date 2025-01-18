package Stars;
//Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//*        *
//**      **
//***    ***
//****  ****
//**********
//****  ****
//***    ***
//**      **
//*        *
import java.util.*;
class Star20 {
    // Function to print pattern20
    public void pattern20(int n) {
        // Initialising the spaces.
        int spaces = 2*n-2;
        // Outer loop to print the row.
        for(int i = 1; i <= 2*n-1; i++){
            // Stars for first half
            int stars = i;
            // Stars for the second half.
            if(i > n) stars = 2*n - i;
            // For printing the stars
            for(int j = 1; j <= stars; j++){
                System.out.print("*");
            }
            // For printing the spaces
            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            // For printing the stars
            for(int j = 1; j <= stars; j++){
                System.out.print("*");
            }
            // Give a line break for new row.
            System.out.println();
            if(i < n) spaces -= 2;
            else spaces += 2;
        }
    }

    public static void main(String[] args) {
        int N = 5;

        // Create an instance of Solution class
        Star20 sol = new Star20();

        sol.pattern20(N);
    }
}

