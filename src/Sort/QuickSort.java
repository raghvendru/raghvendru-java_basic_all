package Sort;

public class QuickSort {
    public int[] quickSort(int[] nums) {
    int n = nums.length;
    qs(nums,0,n-1);
    return nums;
    }
    public void qs(int[] arr,int low,int high){
      //  if(low==high) return;
        if(low<high){
            int partionIndex =ps(arr,low,high);
            qs(arr,low,partionIndex-1);
            qs(arr,partionIndex+1,high);
        }

    }
    public int ps(int[] arr1,int low,int high){
        int i = low;
        int j = high;
        int pI = arr1[low];
        while(i<j){
            while(arr1[i]<=pI && i<=high-1){
                i++;
            }
            while(arr1[j]>pI && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] = temp;

            }

        }
            int temp1 = arr1[low];
            arr1[low] = arr1[j];
            arr1[j] = temp1;
            return j;

    }
    public static void main(String[] args) {
        int[] a = {13,9,4,24,52,6,90};
        QuickSort s = new QuickSort();
        int[] ans = s.quickSort(a);
        for(int num:ans) {
            System.out.print(num+" ");
        }

    }
}
