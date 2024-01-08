package stack2;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        int[] prevSmaller = prevSmaller(heights);
        int[] nextSmaller = nextSmaller(heights);
        int maxArea = 0;
        for(int i=0;i<n;i++) {
            int curArea = (nextSmaller[i] - prevSmaller[i] -1)*heights[i];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;

    }
    public int[] prevSmaller(int[] a) {
        int n = a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=0; i<n;i++) {
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] nextSmaller(int[] a) {
        int n = a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0;i--) {
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = n;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

}
