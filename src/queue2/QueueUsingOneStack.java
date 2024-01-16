package queue2;

import java.util.ArrayDeque;

public class QueueUsingOneStack {
    ArrayDeque<Integer> stack;
    public QueueUsingOneStack() {
        stack = new ArrayDeque<>();
    }
    public int poll() {
        if(stack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack.pop();
    }
    public void offer(int a) {
        insertAtBottom(stack, a);
    }
    private void insertAtBottom(ArrayDeque<Integer> stack, int a) {
        if(stack.isEmpty()) {
            stack.push(a);
            return;
        }
        int x = stack.pop();
        insertAtBottom(stack, a);
        stack.push(x);
    }
    public void printQueue() {
        System.out.println(stack);
    }

}
