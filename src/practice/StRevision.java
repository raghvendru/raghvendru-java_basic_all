package practice;
import java.util.*;

public class StRevision {
    public void st(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StRevision st = new StRevision();
        st.st(n);
    }
}
