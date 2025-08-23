package practice;
import java.util.*;

public class LongestPrefinString {
    public String longest(String[] str){
        int n = str.length;
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        String f = str[0];
        String l = str[n-1];
        for(int i=0;i<Math.min(f.length(),l.length());i++){
            if(f.charAt(i)!=l.charAt(i)){
                return sb.toString();
            }
            sb.append(f.charAt(i));

        }
        return sb.toString();
    }
    public static void main(String[] args){
        LongestPrefinString l = new LongestPrefinString();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of strings");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.println("enter strings");
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        String ans = l.longest(arr);
        System.out.println("longest pref is: "+ans);
    }
}
