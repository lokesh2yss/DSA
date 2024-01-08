package heapanddisjointset;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemainingGifts {
    public long pickGifts(int[] gifts, int k) {
        //create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift: gifts) {
            maxHeap.add(gift);
        }
        System.out.println(maxHeap);
        long remGifts = 0;
        for(int i=0;i<k;i++) {
            //remGifts += Math.floor(Math.sqrt(maxHeap.poll()));
            maxHeap.add((int)Math.sqrt(maxHeap.peek()));
            maxHeap.remove();
        }
        while(!maxHeap.isEmpty()) {
            remGifts += maxHeap.poll();
        }
        return remGifts;
    }
}
