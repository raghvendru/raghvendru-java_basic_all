package practice;
import java.util.*;
public class PrimeCountfromlR {

        public boolean isPrime(int n){
            if(n<=1) return false;
            for(int i=2;i*i<=n;i++){
                if(n%i == 0){
                    return false;
                }
            }
            return true;
        }
        public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
            //your code goes here
            ArrayList<Integer> ans = new ArrayList<>();
            for(int[] q:queries){
                int st =q[0];
                int en = q[1];
                int c= 0;
                for(int i=st;i<=en;i++){
                    if(isPrime(i)){
                        c++;
                    }
                }
                ans.add(c);
            }
            return ans;
        }
        public static void main(String[] args){
            PrimeCountfromlR pr = new PrimeCountfromlR();
            ArrayList<int[]> queries = new ArrayList<>();
            queries.add(new int[]{3, 10});
            queries.add(new int[]{8, 20});
            queries.add(new int[]{1, 5});
            ArrayList<Integer> result = pr.primesInRange(queries);

            for (int count : result) {
                System.out.println(count); // Print the result for each query
            }
        }

}
