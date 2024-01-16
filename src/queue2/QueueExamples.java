package queue2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {
    public static void main(String[] args) {
        /*QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.printQueue();
        System.out.println(q.poll());
        q.printQueue();
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.printQueue();
        System.out.println(q.poll());
        q.printQueue();*/
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        System.out.println(q);
        reverseQ(q,3);
        System.out.println(q);
    }
    public static void reverseQ(Queue<Integer> q, int k) {
        if(q.size() == 1 || k==0) {
            return;
        }
        int front = q.poll();
        reverseQ(q, k-1);
        q.offer(front);
    }

}
