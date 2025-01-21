package BasicHashing;

import java.util.HashMap;
import java.util.Map;

//Highest occurring element in an array
//Given an array of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times. If there are multiple elements that appear a maximum number of times, find the smallest of them.
//Please note that this section might seem a bit difficult without prior knowledge on what hashing is, we will soon try to add basics concepts for your ease! If you know the concepts already please go ahead to give a shot to the problem. Cheers!
public class HighOccurance {
    public int Occ(int[] arr) {
//        int maxCount = 0;
//        int ele = 0;
//        int n = arr.length;
//        boolean[] vis = new boolean[n];
//        for(int i=0;i<n;i++){
//            if(vis[i] ) continue;
//            int count =0;
//            for(int j=i;j<n;j++){
//                if(arr[i]==arr[j]){
//                    count++;
//                    vis[j] = true;
//                }
//            }
//            if(count>maxCount){
//                maxCount=count;
//                ele =arr[i];
//            }else if(count==maxCount){
//                ele = Math.min(ele,arr[i]);
//            }
//        }
//        return ele;
        int maxCount = 0;
        int maxele = 0;
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(arr[i], mp.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> it :mp.entrySet()){
            int ele = it.getKey();
            int cnt = it.getValue();
            if(cnt>maxCount){
                maxCount = cnt;
                maxele =ele;
            } else if (cnt ==maxCount) {
                maxele = Math.min(maxele,ele);
            }
        }
        return maxele;
    }
    public static void main(String[] args) {
        int nums[] ={ 2,4,5,6,2,2,6};
        HighOccurance h = new HighOccurance();
          int ans =   h.Occ(nums);
        System.out.println(ans);
    }
}
