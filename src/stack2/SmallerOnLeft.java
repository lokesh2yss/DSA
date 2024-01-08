package stack2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SmallerOnLeft {
    public static void main(String[] args) {
        int[] a = {3,7,1,4,2,9,11};
        System.out.println(Arrays.toString(smallerOnRight(a)));
    }
    public static int[] smallerOnRight(int[] a) {
        int n = a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && a[i] < a[stack.peek()]) {
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
    public static int[] smallerOnLeft(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && a[i] < a[stack.peek()]) {
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
}
