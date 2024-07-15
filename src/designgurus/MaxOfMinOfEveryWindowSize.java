package designgurus;

import java.util.Arrays;
import java.util.Stack;

public class MaxOfMinOfEveryWindowSize {
    public static void main(String[] args) {
        int[] a = {10,20,30,50,10,70,30};
        System.out.println(Arrays.toString(maxOfMinOfEveryWindowSize(a)));

    }
    public static int[] maxOfMinOfEveryWindowSize(int[] a) {
        int n = a.length;
        int[] prevSmaller = prevSmaller(a);
        int[] nextSmaller = nextSmaller(a);
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        for(int i=0;i<n;i++) {
            int wl = nextSmaller[i] - prevSmaller[i] -1;
            ans[wl-1] = Math.max(ans[wl-1], a[i]);
        }
        for(int i=n-1;i>=1;i--) {
            ans[i-1] = Math.max(ans[i-1], ans[i]);
        }
        return ans;
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
