package BasicMaths;

import java.util.Arrays;
import java.util.Scanner;
//Divisors of a number
//100
//You are given an integer n. You need to find all the divisors of n. Return all the divisors of n as an array or list in a sorted order.
//A number which completely divides another number is called it's divisor.
//Examples://Inp: n = 6
//Output = [1, 2, 3, 6]
//Explanation: The divisors of 6 are 1, 2, 3, 6.
public class DivisorOfNum {
    public  int[] div(int n){
//        int[] res = new int[n];
//        int count = 0;
//        for(int i=1;i<=n;i++){
//            if(n%i==0){
//                res[count++] = i;
//            }
//        }
//        return Arrays.copyOf(res,count);
        int[] res = new int[n];
        int count = 0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                res[count++] = i;
            }
            if(i!=(n/i)){
                res[count++] = n/i;
            }
        }
        int[] ans = Arrays.copyOf(res,count);
        Arrays.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        DivisorOfNum d = new DivisorOfNum();
        int[] res =d.div(n);
        for (int re : res) {
            System.out.println(re);

        }
    }
}
