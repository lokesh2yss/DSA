package stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) return;
        int a = s.pop();
        reverseStack(s);
        insertAtLast(s,a);
    }
    public void insertAtLast(Stack<Integer> s, int a) {
        if(s.isEmpty()) {
            s.push(a);
            return;
        }
        int b = s.pop();
        insertAtLast(s,a);
        s.push(b);

    }
}
