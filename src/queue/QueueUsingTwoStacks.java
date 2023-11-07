package queue;

import java.util.ArrayDeque;

public class QueueUsingTwoStacks {
    ArrayDeque<Integer> stack1;
    ArrayDeque<Integer> stack2;
    public QueueUsingTwoStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    public void enqueue(int data) {
        stack1.push(data);
    }
    public int dequeue() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
