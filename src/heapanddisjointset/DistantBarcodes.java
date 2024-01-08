package heapanddisjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n;i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i],0) +1);

        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        int[] res = new int[n];
        int index = 0;
        while(maxHeap.size() >0) {
            int a = maxHeap.poll();
            res[index++] = a;
            if(maxHeap.size() ==0) break;
            int b  = maxHeap.poll();
            res[index++]  = b;
            update(map, maxHeap,a);
            update(map, maxHeap,b);
        }
        return res;
    }
    private void update(Map<Integer, Integer> map, PriorityQueue<Integer> maxHeap, int a) {
        if(map.get(a) == 1) {
            map.remove(a);
        }
        else {
            map.put(a, map.get(a)-1);
            maxHeap.offer(a);
        }
    }
}
