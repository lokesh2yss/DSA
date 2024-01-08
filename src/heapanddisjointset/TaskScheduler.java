package heapanddisjointset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] a, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0;i<n;i++) {
            map.put(a[i], map.getOrDefault(a[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y-x);
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.offer(entry.getValue());
        }
        int time = 0;
        while(!pq.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<=k;i++) {
                if(!pq.isEmpty()) {
                    tmp.add(pq.poll());
                }
            }
            for(int i=0;i<tmp.size();i++) {
                tmp.set(i, tmp.get(i)-1);
                if(tmp.get(i) > 0) {
                    pq.offer(tmp.get(i));
                }
            }
            time += pq.isEmpty() ? tmp.size(): k+1;
        }
        return time;
    }
}
