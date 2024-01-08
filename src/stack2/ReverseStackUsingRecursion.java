package stack2;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public void reverseStack(Stack<Integer> s) {
        if(s.size() == 0 || s.size() ==1) {
            return;
        }
        int a = s.pop();
        reverseStack(s);
        insertAtBottom(s,a);
    }
    public void insertAtBottom(Stack<Integer> s, int a) {
        if(s.isEmpty()) {
            s.push(a);
            return;
        }
        int temp = s.pop();
        insertAtBottom(s,a);
        s.push(temp);
    }

}
