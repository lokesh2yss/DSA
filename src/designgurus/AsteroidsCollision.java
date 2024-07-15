package designgurus;

import java.util.ArrayDeque;
import java.util.Arrays;

public class AsteroidsCollision {
    public static void main(String[] args) {
        int[] a = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(a)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i= asteroids.length -1; i >= 0; i--) {
            System.out.println(stack);
            while(!stack.isEmpty() && asteroids[i] > 0 && stack.peek() < 0) {
                int top = stack.peek();
                if(Math.abs(top) == Math.abs(asteroids[i])) {
                    asteroids[i] = 0;
                    stack.poll();
                }
                else if(Math.abs(top) > Math.abs(asteroids[i])) {
                    asteroids[i] = 0;
                }
                else {
                    stack.poll();
                }
            }
            if(asteroids[i] != 0) {
                stack.push(asteroids[i]);
            }
        }
        System.out.println(stack);
        int[] ans = new int[stack.size()];
        int n = stack.size();
        for(int i =0;i< n; i++) {
            ans[i] = stack.poll();
        }
        return ans;
    }
}
