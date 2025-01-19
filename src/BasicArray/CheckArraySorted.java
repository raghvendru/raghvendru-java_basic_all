package BasicArray;

import java.util.Scanner;

//Given an array arr of size n, the task is to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order. If the array is sorted then return True, else return False.//Examples:
//Input: n = 5, arr = [1,2,3,4,5]
//Output: True
public class CheckArraySorted {
    public boolean isCheck(int[] arr,int n){
        //brute
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//              if(arr[i]>arr[j]){
//                  return false;
//              }
//            }
//        }
//        return true;
       //optimal
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int n= sc.nextInt();
        int[] a = new int[n];
        System.out.println("enter ele");
        for(int i=0;i<n;i++){
            a[n-1]= sc.nextInt();
         }
        CheckArraySorted c = new CheckArraySorted();
        boolean sort = c.isCheck(a,n);
        System.out.println(sort);
    }
}
