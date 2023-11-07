package queue;

import java.util.ArrayDeque;

public class QueueUsingOneStack {
    ArrayDeque<Integer> stack;
    public QueueUsingOneStack() {
        stack = new ArrayDeque<>();
    }
    public void enqueue(int data) {
        stack.push(data);
    }
    public int dequeue() {
        if(stack.size() ==0) {
            return -1;
        }
        if(stack.size()==1) {
            return stack.pop();
        }
        int top = stack.pop();
        int ans = dequeue();
        stack.push(top);
        return ans;
    }

}
