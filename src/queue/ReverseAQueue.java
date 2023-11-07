package queue;

import java.util.*;

public class ReverseAQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(54);
        q.offer(83);
        q.offer(49);
        q.offer(7);
        q.offer(80);
        q.offer(41);
        q.offer(81);
        //printQueue(q);
        reverse(q,1);
        int i=0;
        while(i<1) {
            if(!q.isEmpty()) {
                int top = q.poll();
                q.offer(top);
            }
            i++;
        }
        printQueue(q);
    }
    public static void reverse(Queue<Integer> q, int k) {
        if(q.isEmpty()) return;
        if(q.size() ==1) return;
        if(k==0) return;
        int top = q.poll();
        reverse(q, k-1);
        q.offer(top);
    }
    public static void printQueue(Queue<Integer> q) {
        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }
        System.out.println();
    }

}
