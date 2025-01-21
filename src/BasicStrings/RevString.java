package BasicStrings;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;
//Reverse a string
//100
//Given a string, the task is to reverse it. The string is represented by an array of characters s. Perform the reversal in place with O(1) extra memory.
//Examples:
//Input : s = ["h", "e" ,"l" ,"l" ,"o"]
//Output : ["o", "l", "l", "e", "h"]
//Explanation : The given string is s = "hello" and after reversing it becomes s = "olleh".
public class RevString {
//    public void reverseString(Vector<Character> s) {
//        Stack<Character> st = new Stack<>();
//        for(char c : s){
//            st.push(c);
//        }
//        for(int i=0;i<s.size();i++){
//            s.set(i,st.pop());
//        }
//        return;
//    }
    public void reverseString(Vector<Character> s) {
        int start = 0, end = s.size() - 1;
        while (start < end) {
            char ch = s.get(start);
            s.set(start, s.get(end));
            s.set(end, ch);
            start++;
            end--;
        }
        return;
    }
    public static void main(String[] args) {
        Vector<Character> str =
                new Vector<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        RevString sol = new RevString();
        sol.reverseString(str);
        for (char c : str) {
            System.out.print(c);
        }
    }
    }

