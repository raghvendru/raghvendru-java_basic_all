package practice;
import java.util.*;
public class array {
    public boolean isSorted(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter elements");
        for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
        }
        array a = new array();
        System.out.print( a.isSorted(arr,n));
    }
}
