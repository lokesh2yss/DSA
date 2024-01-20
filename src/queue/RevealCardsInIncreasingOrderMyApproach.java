package queue;
import java.util.*;
public class RevealCardsInIncreasingOrderMyApproach {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(deck[n-1]);
        for(int i=n-2;i>0;i--) {
            dq.offerFirst(dq.pollLast());
            dq.offerFirst(deck[i]);
        }
        dq.offerFirst(dq.pollLast());
        dq.offerFirst(deck[0]);
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            if(!dq.isEmpty()) {
                ans[i] = dq.pollFirst();
            }
        }
        return ans;
    }
}
