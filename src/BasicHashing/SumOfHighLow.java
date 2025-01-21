package BasicHashing;

import java.util.HashMap;

public class SumOfHighLow {
    public int Sum(int[] arr){
//        int maxFreq = 0;
//        int n = arr.length;
//        int minFreq=n;
//        boolean[] vis = new boolean[n];
//        for(int i =0;i<n;i++){
//            if(vis[i]) continue;
//            int count = 0;
//            for(int j=i;j<n;j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                    vis[j] = true;
//                }
//            }
//                    maxFreq = Math.max(maxFreq,count);
//                    minFreq = Math.min(minFreq,count);
//            }
//        return  maxFreq+minFreq;
        int n = arr.length;
        int maxFreq = 0, minFreq = n;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }
        for (int freq : mpp.values()) {
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }
        return maxFreq + minFreq;
        }

    public static void main(String[] args) {
        int arr[] ={ 2,4,5,4,2,2,6};
        SumOfHighLow h = new SumOfHighLow();
        int ans =   h.Sum(arr);
        System.out.println(ans);
    }
}
