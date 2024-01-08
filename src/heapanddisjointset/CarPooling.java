package heapanddisjointset;

import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.point - b.point);
        int n = trips.length;
        for(int i=0;i<n;i++) {
            Pair p = new Pair(trips[i][1], trips[i][0]);
            pq.offer(p);
            Pair p1 = new Pair(trips[i][2], -trips[i][0]);
            pq.offer(p1);
        }
        int onBoard = 0;
        while(!pq.isEmpty()) {
            onBoard += pq.poll().passengers;
            if(onBoard > capacity) {
                return false;
            }
        }
        return true;
    }
    class Pair {
        int point;
        int passengers;
        public Pair(int point, int passengers) {
            this.point = point;
            this.passengers = passengers;
        }
    }
}
