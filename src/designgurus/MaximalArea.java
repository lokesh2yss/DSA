package designgurus;

import java.util.Arrays;
import java.util.Stack;

public class MaximalArea {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        System.out.println(getMaximalArea(mat));

    }
    public static int getMaximalArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] a = mat[0];
        int maxArea = largestRectangleArea(a);
        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    a[j] = 0;
                }
                else {
                    a[j] = a[j] + 1;
                }
            }
            System.out.println(Arrays.toString(a));
            maxArea = Math.max(largestRectangleArea(a), maxArea);
        }
        return maxArea;
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
