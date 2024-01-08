package heapanddisjointset;

import java.util.Arrays;

public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        if(k==1 || k==weights.length)
        {
            return 0;
        }
        int[] score = new int[weights.length - 1];
        for(int i=0;i<weights.length-1;i++)
        {
            score[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(score);
        long minsum = 0,maxsum=0;
        for(int i=0;i<k-1;i++)
        {
            minsum += score[i];
            maxsum += score[score.length - i -1];
        }
        return (maxsum - minsum);
        /*if(k==1) return 0;
        if(k > weights.length) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = weights.length;
        for(int i=0;i<n-1;i++) {
          pq.offer(weights[i] + weights[i+1]);
        }
        int maxScore = 0;
        int minScore = 0;
        for(int i=0; i<k-1;i++) {
          maxScore += pq.poll();
        }
        while(pq.size() >= k) {
          System.out.println(pq.size());
          pq.poll();
        }
        System.out.println(pq.size());
        for(int i=0;i<k-1;i++) {
          minScore += pq.poll();
        }
        return maxScore - minScore;*/
    }
}
