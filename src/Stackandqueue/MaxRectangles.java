package Stackandqueue;
import java.util.*;
public class MaxRectangles {
        private int largestRectangleArea(int[] heights) {
            int n = heights.length; // Size of array
            Stack<Integer> st = new Stack<>();
            // To store largest area
            int largestArea = 0;
            // To store current area
            int area;
            int nse, pse;
            for(int i = 0; i < n; i++) {
                while(!st.isEmpty() &&
                        heights[st.peek()] >= heights[i]){
                    int ind = st.pop();
                    pse = st.isEmpty() ? -1 : st.peek();
                    nse = i;
                    area = heights[ind] * (nse - pse - 1);
                    largestArea = Math.max(largestArea, area);
                }
                st.push(i);
            }
            while(!st.isEmpty()) {
                nse = n;
                int ind = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                area = heights[ind] * (nse - pse - 1);
                largestArea = Math.max(largestArea, area);
            }
            return largestArea;
        }
        public int maximalAreaOfSubMatrixOfAll1(int[][] matrix){
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] prefixSum = new int[n][m];
            for(int j = 0; j < m; j++) {
                int sum = 0;
                for(int i = 0; i < n; i++) {
                    sum += matrix[i][j];
                    if(matrix[i][j] == 0) {
                        prefixSum[i][j] = 0;
                        sum = 0;
                    } else {
                        prefixSum[i][j] = sum;
                    }
                }
            }
            int maxArea = 0;
            for(int i = 0; i < n; i++) {
                int area = largestRectangleArea(prefixSum[i]);
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }
        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 0, 1, 0, 0},
                    {1, 0, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 0, 0, 1, 0}
            };
            MaxRectangles sol = new MaxRectangles();
            int ans = sol.maximalAreaOfSubMatrixOfAll1(matrix);
            System.out.println("The largest rectangle area containing all 1s is: " + ans);
        }
    }

