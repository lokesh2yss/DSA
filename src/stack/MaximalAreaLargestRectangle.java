package stack;

import java.util.ArrayDeque;

public class MaximalAreaLargestRectangle {
    public int maximalRectangle(char[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] curRow = new int[n];
        for(int i=0;i<n;i++) {
            curRow[i] = matrix[0][i] - '0';
        }

        int maxArea = largestAreaHistogram(curRow);
        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] =='1') {
                    curRow[j]++;
                }
                else {
                    curRow[j] = 0;
                }
            }
            int curArea = largestAreaHistogram(curRow);
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;

    }
    public int largestAreaHistogram(int[] a) {
        int n = a.length;
        int[] smallerOnLeft = smallerOnLeft(a);
        int[] smallerOnRight = smallerOnRight(a);
        int largestArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int currArea = (smallerOnRight[i] - smallerOnLeft[i] -1)*a[i];
            largestArea = Math.max(largestArea, currArea);
        }
        return largestArea;
    }
    public int[] smallerOnLeft(int[] a) {
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
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
    public int[] smallerOnRight(int[] a) {
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--) {
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
