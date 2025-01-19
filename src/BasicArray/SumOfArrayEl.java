package BasicArray;

import java.util.Scanner;

//Sum of array elements
//Given an array arr of size n, the task is to find the sum of all the elements in the array
//Examples:
//Input: n=5, arr = [1,2,3,4,5]
//Output: 15
//Explanation: Sum of all the elements is 1+2+3+4+5 = 15
public class SumOfArrayEl {
    public int sum(int[] arr,int n){
        int res = 0;
        for (int j : arr) {
            res = res + j;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumOfArrayEl s = new SumOfArrayEl();
        System.out.println("enter size");
       int n =  sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter ele's");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int res = s.sum(arr,n);
        System.out.println(res);
    }
}
