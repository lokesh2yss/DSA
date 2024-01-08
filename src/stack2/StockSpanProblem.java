package stack2;

import java.util.ArrayDeque;

public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n)
    {
        int[] ans = new int[n];
        ans[0] = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = i+1;
            }
            else {
                ans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return ans;

    }
}
