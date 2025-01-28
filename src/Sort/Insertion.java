package Sort;
//select an ele and place it in correct order
public class Insertion {
    public int[] insertionSort(int[] nums) {
    int n = nums.length;
    for(int i=0;i<n;i++){
        int j = i;
        while(j>0 && nums[j]<nums[j-1]){
            int temp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = temp;
            j--;
        }
    }
    return nums;
    }
    public static void main(String[] args) {
        int[] a = {13,9,4,24,52,6,90};
        Insertion s = new Insertion();
        int[] ans = s.insertionSort(a);
        for(int num:ans) {
            System.out.print(num+" ");
        }

    }
}
