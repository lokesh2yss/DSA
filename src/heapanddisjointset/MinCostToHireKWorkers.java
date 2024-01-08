package heapanddisjointset;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for(int i=0;i<n;i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        double cost = Double.MAX_VALUE;
        int totalQuality = 0;
        for(Worker worker: workers) {
            totalQuality += worker.getQuality();
            maxHeap.offer(worker.getQuality());
            if(maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            if(maxHeap.size() == k) {
                cost = Math.min(cost, worker.getRatio()*totalQuality);
            }
        }
        return round(cost,2);
    }
    class Worker implements Comparable<Worker> {
        private int quality;
        private int wage;
        public Worker(int q, int w) {
            this.quality = q;
            this.wage = w;
        }
        public int getQuality() {
            return quality;
        }
        public double getRatio() {
            return (double) wage/quality;
        }
        public int compareTo(Worker otherWorker) {
            if(this.getRatio() > otherWorker.getRatio()) return 1;
            if(this.getRatio() < otherWorker.getRatio()) return -1;
            return 0;
        }
    }
}
