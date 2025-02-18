package Greedy;
import java.util.*;

public class AssignCookies {
        public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
            int n = Student.length;
            int m = Cookie.length;
            // Pointers
            int l = 0, r = 0;
            // Sorting of arrays
            Arrays.sort(Student);
            Arrays.sort(Cookie);

            // Traverse through both arrays
            while (l < n && r < m) {
            /*If the current cookie can satisfy
            the current student, move to the
            next student*/
                if (Cookie[r] >= Student[l]) {
                    l++;
                }
                // Move to next cookie
                r++;
            }
            // Return number of students
            return l;
        }
        public static void main(String[] args) {
            // Example input
            int[] Student = {1, 2};
            int[] Cookie = {1, 2, 3};

            // Create a Solution object
            AssignCookies solution = new AssignCookies();

            // Call the findMaximumCookieStudents function
            int result = solution.findMaximumCookieStudents(Student, Cookie);

            // Output the result
            System.out.println("Number of students satisfied: " + result);
        }
    }


