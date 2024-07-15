package designgurus;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] a = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stockSpan(a)));
    }
    public static int[] stockSpan(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && a[i] >= a[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = i + 1;
            else ans[i] = i - stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
