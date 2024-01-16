package queue;
import java.util.*;
public class ShortestSubArrayWithSumAtLeastKMethod2 {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int shortestLength = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int j = 0;
        for(int i=0;i<n;i++) {
            if(sum==0 && A[i] <0) {
                j++;
                continue;
            }
            sum += A[i];
            q.offer(A[i]);
            if(sum >= K) {
                shortestLength = Math.min(shortestLength,i-j+1);
            }
            while(sum >= K) {
                sum -= q.poll();
                j++;
                if(sum >=K) {
                    shortestLength = Math.min(shortestLength,i-j+1);
                    int l = i;
                    int sum2 = sum;
                    while(sum2 >= K) {
                        sum2 -= A[l];
                        l--;
                        if(sum2 >= K) {
                            shortestLength = Math.min(shortestLength,l-j+1);
                        }
                    }
                }
            }
        }
        return shortestLength==Integer.MAX_VALUE?-1:shortestLength;
    }
}
