package BasicHashing;

import java.util.HashMap;
import java.util.Map;

//Second highest occurring element
//Given an array of n integers, find the second most frequent element in it. If there are multiple elements that appear a maximum number of times, find the smallest of them. If second most frequent element does not exist return -1.
//Examples:
//Input: arr = [1, 2, 2, 3, 3, 3]
//Output: 2
//Explanation: The number 2 appears the second most (2 times) and number 3 appears the most(3 times).
public class SecondHigh {
//     public int secondMostFrequentElement(int[] nums) {
//            int n = nums.length;
//            int maxFreq = 0;
//            int secMaxFreq = 0;
//            int maxEle = -1, secEle = -1;
//            boolean[] visited = new boolean[n];
//            for(int i = 0; i < n; i++) {
//                if(visited[i]) continue;
//                int freq = 0;
//                for(int j = i; j < n; j++) {
//                    if(nums[i] == nums[j]) {
//                        freq++;
//                        visited[j] = true;
//                    }
//                }
//                if(freq > maxFreq) {
//                    secMaxFreq = maxFreq;
//                    maxFreq = freq;
//                    secEle = maxEle;
//                    maxEle = nums[i];
//                }
//                else if(freq == maxFreq) {
//                    maxEle = Math.min(maxEle, nums[i]);
//                }
//                else if(freq > secMaxFreq) {
//                    secMaxFreq = freq;
//                    secEle = nums[i];
//                }
//                else if(freq == secMaxFreq) {
//                    secEle = Math.min(secEle, nums[i]);
//                }
//            }
//            return secEle;
//    }

    public int secondMostFrequentElement(int[] nums) {
        int n = nums.length;
        int maxFreq = 0, secMaxFreq = 0;
        int maxEle = -1, secEle = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // Updating hashmap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Va
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = ele;
            }
            else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            }
            else if(freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }
        return secEle;
    }
    public static void main(String[] args) {
        int nums[] ={ 2,4,5,4,2,2,6};
        SecondHigh h = new SecondHigh();
        int ans =   h.secondMostFrequentElement(nums);
        System.out.println(ans);
    }
}
