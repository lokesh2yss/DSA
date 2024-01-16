package queue2;

import java.util.ArrayDeque;

public class QueueUsingTwoStacks {
    ArrayDeque<Integer> stack1;
    ArrayDeque<Integer> stack2;
    public QueueUsingTwoStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    public void offer(int a) {
        stack1.push(a);
    }
    public int poll() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
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
    public void printQueue() {
        System.out.println(stack1);
    }
}
