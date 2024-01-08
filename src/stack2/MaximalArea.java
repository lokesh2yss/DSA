package stack2;

import java.util.ArrayDeque;

public class MaximalArea {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = matrix[0][i] -'0';
        }
        int maxArea = getMaxAreaInHistogram(arr);
        for(int i=1;i<m; i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] =='1') {
                    arr[j]++;
                }
                else {
                    arr[j] = 0;
                }
            }
            int curArea = getMaxAreaInHistogram(arr);
            maxArea = Math.max(curArea, maxArea);
        }

        return maxArea;

    }
    public int getMaxAreaInHistogram(int[] a) {
        int n = a.length;
        int[] prevSmaller = prevSmaller(a);
        int[] nextSmaller = nextSmaller(a);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int curArea = ( nextSmaller[i] - prevSmaller[i] -1 )* a[i];
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

        for(int i=n-1; i>=0; i--) {
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
