package Advanced.String;
import java.util.ArrayList;
import java.util.List;
//Reverse every word in a string
//Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ). A word is defined as a sequence of non-space characters. The words in s are separated by at least one space.
//Return a string with the words in reverse order, concatenated by a single space.
//Constraints:
//1 <= s.length <= 104
//s contains English letters (upper-case and lower-case), digits, and spaces ' '.
//There is at least one word in s.
//Input: s = "welcome to the jungle"
//Output: "jungle the to welcome"
//Explanation: The words in the input string are "welcome", "to", "the", and "jungle". Reversing the order of these words gives "jungle", "the", "to", and "welcome". The output string should have exactly one space between each word.
public class CountWordsRev {
    public void rev(char[] arr,int start,int end){
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public String count(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i=0,j=0,start=0,end=0;
        rev(arr,0,n-1);

        while(j<n){
            while(j<n && arr[j] == 0 ) j++;
            start = i ;
            while(j<n && arr[j] !=0 ){
                arr[i] = arr[j];
                i++;
                j++;
            }
            end = i-1;

          rev(arr,start,end);
          if(i<n) arr[i++] = ' ';
        }
        return new String(arr).substring(0,end+1);
//        int n = s.length();
//        List<String> words = new ArrayList<>();
//        int start,end;
//        int i = 0;
//        while(i<n){
//            while(i<n && s.charAt(i) == ' ') i++;
//            if(i>=n) break;
//            start = i;
//            while(i<n && s.charAt(i) != ' ') i++;
//            end = i-1;
//            String wordFound = s.substring(start,end+1);
//            words.add(wordFound);
//        }
//        StringBuilder st = new StringBuilder();
//        for(int j = words.size()-1;j>=0;j--){
//            st.append(words.get(j));
//            if(j!=0) st.append(' ');
//        }
//        return st.toString();

        }

    public static void main(String[] args) {
        String s = " amazing coding skills  ";
        CountWordsRev sol = new CountWordsRev();
        String ans = sol.count(s);
        System.out.println("Input string: " + s);
        System.out.println("After reversing every word: " + ans);
    }
}
