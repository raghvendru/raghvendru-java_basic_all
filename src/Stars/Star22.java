package Stars;
//5 5 5 5 5 5 5 5 5
//5 4 4 4 4 4 4 4 5
//5 4 3 3 3 3 3 4 5
//5 4 3 2 2 2 3 4 5
//5 4 3 2 1 2 3 4 5
//5 4 3 2 2 2 3 4 5
//5 4 3 3 3 3 3 4 5
//5 4 4 4 4 4 4 4 5
//5 5 5 5 5 5 5 5 5
class Star22 {
    // Function to print pattern22
    public void pattern22(int n) {
        // Outer loop for the rows
        for (int i = 0; i < 2 * n - 1; i++) {
            // Inner loop for the columns
            for (int j = 0; j < 2 * n - 1; j++) {
                /* Initialising the top, down, left
                and right indices of a cell.*/
                int top = i;
                int bottom = j;
                int right = (2 * n - 2) - j;
                int left = (2 * n - 2) - i;
                /* Minimum of 4 directions and then we
                subtract from n because previously we
                would get a pattern whose border has 0's,
                but we want with border n's and then
                decreasing inside.*/
                System.out.print((n - Math.min(Math.min(top, bottom), Math.min(left, right))) + " ");
            }
            // Move to the next row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 5;

        // Create an instance of Solution class
        Star22 sol = new Star22();

        sol.pattern22(N);
    }
}

