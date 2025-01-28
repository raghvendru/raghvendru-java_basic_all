package Sort;
//select min and swap
public class Selection {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<=n-2;i++){
            int mini = i;
            for(int j=i;j<=n-1;j++){
                if(nums[j]<nums[mini]){
                    mini = j ;
                }
            }
            int temp = nums[i];
            nums[i] = nums[mini];
            nums[mini] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {13,9,4,24,52,6,90};
        Selection s = new Selection();
        int[] ans = s.selectionSort(a);
        for(int num:ans) {
            System.out.print(num+" ");
           }
    }

}
