package stack2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NearestSmallerElements {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A)
    {
        int n = A.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int cur = A.get(i);
            while(!stack.isEmpty() && A.get(stack.peek()) >= cur) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans.add(-1);
            }
            else {
                ans.add(A.get(stack.peek()));
            }
            stack.push(i);
        }
        return ans;
    }
}
