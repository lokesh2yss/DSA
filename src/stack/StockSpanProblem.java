package stack;

import java.util.ArrayDeque;

public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n)
    {
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        ans[0] = 1;
        for(int i=1; i<n;i++) {
            while(!stack.isEmpty()) {
                int top = stack.peek();
                if(price[top] > price[i]) {
                    break;
                }
                else {
                    stack.pop();
                }
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
