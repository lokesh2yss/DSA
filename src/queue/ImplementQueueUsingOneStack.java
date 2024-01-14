package queue;
import java.util.*;
public class ImplementQueueUsingOneStack {
    Stack<Integer> stack = new Stack<>();

    void Push(int x) {
        stack.push(x);
    }
    int Pop() {
        if(stack.isEmpty()) {
            return -1;
        }
        if(stack.size() == 1) {
            return stack.pop();
        }
        int top = stack.pop();
        int ans = Pop();
        stack.push(top);
        return ans;
    }
}
