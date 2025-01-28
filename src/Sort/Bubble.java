package Sort;
//select max and adjecent swap
public class Bubble {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
    for(int i=n-1;i>=0;i--){
        for(int j =0;j<=i-1;j++ ){
            if(nums[j]>nums[j+1]){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
    return nums;
    }
    public static void main(String[] args) {
        int[] a = {13,9,4,24,52,6,90};
        Bubble s = new Bubble();
        int[] ans = s.bubbleSort(a);
        for(int num:ans) {
            System.out.print(num+" ");
        }

    }
}
