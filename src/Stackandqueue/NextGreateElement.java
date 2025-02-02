package Stackandqueue;
import java.util.*;
public class NextGreateElement {
    public int[] nextLargerElement(int[] arr) {

        int n = arr.length; // size of array

        // To store the next greater elements
        int[] ans = new int[n];

        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();

        // Start traversing from the back
        for(int i = n - 1; i >= 0; i--) {

            // Get the current element
            int currEle = arr[i];

            /* Pop the elements in the stack until
            the stack is not empty and the top
            element is not the greater element */
            while(!st.isEmpty() &&
                    st.peek() <= currEle) {
                st.pop();
            }

            /* If the greater element is not
            found, stack will be empty */
            if(st.isEmpty())
                ans[i] = -1;

                // Else store the answer
            else
                ans[i] = st.peek();

            /* Push the current element in the stack
            maintaining the decreasing order */
            st.push(currEle);
        }

        // Return the result
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 3, 2, 4};

        /* Creating an instance of
        Solution class */
        NextGreateElement sol = new NextGreateElement();

        /* Function call to find the next greater
        element for each element in the array */
        int[] ans = sol.nextLargerElement(arr);

        System.out.println("The next greater elements are: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

