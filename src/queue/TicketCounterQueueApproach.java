package queue;
import java.util.*;
public class TicketCounterQueueApproach {
    public static int distributeTicket(int N,int K) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            dq.offer(i);
        }
        int ans = -1;
        while(!dq.isEmpty()) {
            for(int i=0;i<K;i++) {
                if(!dq.isEmpty()) {
                    ans = dq.pollFirst();
                }
                else {
                    break;
                }
            }
            for(int i=0;i<K;i++) {
                if(!dq.isEmpty()) {
                    ans = dq.pollLast();
                }
                else {
                    break;
                }
            }
        }
        return ans;
    }
}
