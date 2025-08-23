package practice;
import java.util.*;
public class st {
    public void pat(int n)
    {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=1;j<=(2*n)-(2*i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        st s = new st();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        s.pat(n);
    }

}
