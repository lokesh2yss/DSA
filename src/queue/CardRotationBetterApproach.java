package queue;
import java.util.*;
public class CardRotationBetterApproach {
    ArrayList<Integer> rotation(int n){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n-1;i>0;i--) {
            q.offerFirst(i);
            for(int j=0;j<i;j++) {
                q.offerFirst(q.pollLast());
            }
        }
        while(!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}
