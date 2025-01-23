package Advanced.String;
//Minimum number of bracket reversals to make an expression balanced
//Given a string s consisting of only opening and closing brackets '(' and ')', find out the minimum number of reversals required to convert the string into a balanced expression.
//If it is not possible to make the brackets balanced, return -1. A reversal means changing '(' to ')' or vice-versa.
public class BrackReversal {
    public int countRev(String s) {
    int n = s.length();
    int open=0,close=0;
    if(n%2 !=0) return -1;
    for(int i=0;i<n;i++){
        if(s.charAt(i) == '('){
            open++;
        }else {
            if(open>0) open--;
            else close++;
        }
    }
    int ans = (open/2)+(open%2)+(close/2)+(close%2);
    return  ans;
    }
    public static void main(String[] args) {
        BrackReversal ab = new BrackReversal();
        String st = "(())))()";
        int ans = ab.countRev(st);
        System.out.println("reversal needed is " + ans);

    }
}
