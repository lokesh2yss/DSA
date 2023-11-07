package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NearestSmallerElement {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A)
    {
        int n = A.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(-1);
        stack.push(0);
        for(int i=1; i<n; i++) {
            int current = A.get(i);
            if(current > A.get(stack.peek())) {
                ans.add(A.get(stack.peek()));
            }
            else {
                while(!stack.isEmpty() && current <= A.get(stack.peek())) {
                    int popped = stack.pop();
                }
                if(stack.isEmpty()) {
                    ans.add(-1);
                }
                else {
                    ans.add(A.get(stack.peek()));
                }
            }
            stack.push(i);
        }
        return ans;


    }
}
