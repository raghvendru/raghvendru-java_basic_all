package Stackandqueue;
import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {

        // Size of the array
        int n = asteroids.length;

        // List implementation of stack
        List<Integer> st = new ArrayList<>();

        // Traverse all the asteroids
        for(int i = 0; i < n; i++) {

            /* Push the asteroid in stack if a
            right moving asteroid is seen */
            if(asteroids[i] > 0) {
                st.add(asteroids[i]);
            }
            /* Else if the asteroid is moving
            left, perform the collisions */
            else {
                /* Until the right moving asteroids are
                smaller in size, keep on destroying them */
                while(!st.isEmpty() && st.get(st.size() - 1) > 0 &&
                        st.get(st.size() - 1) < Math.abs(asteroids[i])) {

                    // Destroy the asteroid
                    st.remove(st.size() - 1);
                }

                /* If there is right moving asteroid
                which is of same size */
                if(!st.isEmpty() &&
                        st.get(st.size() - 1) == Math.abs(asteroids[i])) {

                    // Destroy both the asteroids
                    st.remove(st.size() - 1);
                }

                else if(st.isEmpty() ||
                        st.get(st.size() - 1) < 0){

                    // Storing the array in final state
                    st.add(asteroids[i]);
                }
            }
        }
        int[] result = new int[st.size()];
        for(int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, -10};
        AsteroidCollision sol = new AsteroidCollision();
        int[] ans = sol.asteroidCollision(arr);
        System.out.print("The state of asteroids after collisions is: ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

