package Greedy;
import java.util.*;
public class InsertInterval {
        public int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int i = 0;
            // Get total intervals
            int n = intervals.length;
            // Insert intervals before newInterval
            while (i < n && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                // Move to next interval
                i++;
            }
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                // Move to the next interval
                i++;
            }
            res.add(newInterval);
            while (i < n) {
                res.add(intervals[i]);
                // Move to next interval
                i++;
            }
            return res.toArray(new int[res.size()][]);
        }
        public static void main(String[] args) {
            InsertInterval sol = new InsertInterval();
            int[][] intervals = {{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
            int[] newInterval = {5, 8};
            System.out.print("Intervals Array: ");
            for (int[] interval : intervals) {
                System.out.print("[" + interval[0] + ", " + interval[1] + "], ");
            }
            System.out.println();
            System.out.print("New Interval to be Inserted: ");
            System.out.println("[" + newInterval[0] + ", " + newInterval[1] + "]");
            int[][] result = sol.insertNewInterval(intervals, newInterval);
            System.out.print("Resulting Intervals after Insertion: ");
            for (int[] interval : result) {
                System.out.print("[" + interval[0] + ", " + interval[1] + "], ");
            }
            System.out.println();
        }
    }

