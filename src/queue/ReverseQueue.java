package queue;
import java.util.*;
public class ReverseQueue {
    public static Queue<Integer> reverseQueueFirstKElementsBetter(int k, Queue<Integer> queue) {
        int n = queue.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<k;i++) {
            if(!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }
        for(int i=0;i<k;i++) {
            if(!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
        }

        for(int i=0;i<n-k;i++) {
            if(!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return queue;
    }
    public static Queue<Integer> reverseQueueFirstKElements(int k, Queue<Integer> queue) {
        Stack<Integer> st = new Stack<>();
        //move the first k elements into the stack
        for(int i=0;i<k;i++) {
            if(!queue.isEmpty()) {
                st.push(queue.poll());
            }
        }
        Queue<Integer> q = new LinkedList<>();
        while(!st.isEmpty()) {
            q.offer(st.pop());
        }
        while(!queue.isEmpty()) {
            q.offer(queue.poll());
        }
        while(!q.isEmpty()) {
            queue.offer(q.poll());
        }
        //printQueue(q);
        return queue;
    }
    public static void printQueue(Queue<Integer> q) {
        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }
        System.out.println();
    }

}
