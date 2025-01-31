package Greedy;
import java.util.*;
public class Candy {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int i = 1;
            int sum = 1;
            // Loop the ratings array
            while (i < n) {
                if (ratings[i] == ratings[i - 1]) {
                    sum = sum + 1;
                    /* Move to the next child*/
                    i++;
                    continue;
                }
                int peak = 1;
                while (i < n && ratings[i] > ratings[i - 1]) {
                    peak += 1;
                    sum += peak;
                    i++;
                }
                int down = 1;
                while (i < n && ratings[i] < ratings[i - 1]) {
                    sum += down;
                    i++;
                    down++;
                }
                if (down > peak) {
                    sum += (down - peak);
                }
            }
            return sum;
        }

        public static void main(String[] args) {
            int[] ratings = {0, 2, 4, 3, 2, 1, 1, 3, 4, 6, 4, 0, 0};
            System.out.print("Ratings of Children: ");
            for(int rating : ratings){
                System.out.print(rating + " ");
            }
            System.out.println();
            Candy sol = new Candy();
            int result = sol.candy(ratings);
            System.out.println("Minimum number of candies needed: " + result);
        }
    }



