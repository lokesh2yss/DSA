package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxMinEveryWindow {
    public static void main(String[] args) {
        int[] a = {3,6,9,7,11,2,5};
        //int[] a = {2,7,1,4,3,5};
        int[] ans = maxOfMin(a,7);
        for(int e:ans) {
            System.out.print(e+ " ");
        }
    }
    public static int[] maxOfMin(int[] arr, int n) {
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        int[] smallerOnLeft = smallerOnLeft(arr,n);
        int[] smallerOnRight = smallerOnRight(arr,n);

        for(int i=0; i<n;i++) {
            int wl = smallerOnRight[i] - smallerOnLeft[i] -1;
            ans[wl-1] = Math.max(ans[wl-1], arr[i]);
        }

        for(int i= n-2; i>=0;i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return ans;

    }
    public static int[] smallerOnLeft(int[] a, int n) {
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
    public static int[] smallerOnRight(int[] a, int n) {
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
