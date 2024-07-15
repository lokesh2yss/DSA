package designgurus;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }
    public static int largestRectangleArea(int[] heights) {
        int[] prevSmaller = prevSmaller(heights);
        int[] nextSmaller = nextSmaller(heights);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<heights.length;i++) {
            max = Math.max(max, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }
        return max;
    }
    public static int[] nextSmaller(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--) {
            while(!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = n;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int[] prevSmaller(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
