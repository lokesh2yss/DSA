package stack2;

import java.util.ArrayDeque;

public class MaximumOfMinimumOfEveryWindowSize {
    public static int[] maxOfMin(int[] arr, int n) {
        int[] left = smallerOnLeft(arr);
        int[] right = smallerOnRight(arr);
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            int wl = right[i] - left[i] -1;
            ans[wl-1] = Math.max(ans[wl-1], arr[i]);
        }
        for(int i=n-2; i>=0;i--) {
            ans[i] = Math.max(ans[i],ans[i+1]);
        }
        return ans;

    }
    public static int[] smallerOnLeft(int[] a) {
        int n = a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
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
    public static int[] smallerOnRight(int[] a) {
        int n = a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
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
