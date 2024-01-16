package queue;
import java.util.*;
public class ReverseQueueUsingRecursion {
    public static Queue<Integer> reverseQueueFirstKElements(int k, Queue<Integer> queue) {
        int n = queue.size();
        reverseQ(queue, k);
        for(int i=0;i<n-k;i++) {
            queue.offer(queue.poll());
        }
        return queue;
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
