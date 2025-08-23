package practice;
import java.util.*;

public class SumOfArrayEL {
    public int sum(int[] nums){
        int n = nums.length;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum = sum+nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfArrayEL s = new SumOfArrayEL();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = s.sum(arr);
        System.out.printf("sum is %d",ans);

    }
}
