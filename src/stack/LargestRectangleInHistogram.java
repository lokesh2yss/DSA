package stack;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        int[] prevSmaller = prevSmaller(heights);
        int[] nextSmaller = nextSmaller(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int currArea = (nextSmaller[i] - prevSmaller[i] - 1)*heights[i];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;

    }
    public int[] prevSmaller(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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
    public int[] nextSmaller(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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
