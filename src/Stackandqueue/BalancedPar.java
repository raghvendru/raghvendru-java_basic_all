package Stackandqueue;
import java.util.*  ;
public class BalancedPar {
    private boolean isMatched(char open, char close) {

        // Match
        if((open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}')
        )
            return true;

        // Mismatch
        return false;
    }

    /* Function to check if the
    string is valid */
    public boolean isValid(String str) {

        // Initialize a stack
        Stack<Character> st = new Stack<>();

        // Start iterating on the string
        for(int i=0; i < str.length(); i++) {

            // If an opening bracket is found
            if(str.charAt(i) == '(' || str.charAt(i) == '[' ||
                    str.charAt(i) == '{') {

                // Push on top of stack
                st.push(str.charAt(i));
            }

            // Else if a closing bracket is found
            else {
                // Return false if stack is empty
                if(st.isEmpty()) return false;

                // Get the top element from stack
                char ch = st.peek();
                st.pop();

                /* If the opening and closing brackets
                are not matched, return false */
                if(!isMatched(ch, str.charAt(i))) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[{}()]";
        BalancedPar sol = new BalancedPar();
        boolean ans = sol.isValid(str);

        if(ans)
            System.out.println("The given string is valid.");
        else
            System.out.println("The given string is invalid.");
    }
}
