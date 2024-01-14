package queue;
import java.util.*;
public class MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] ps = new int[2*len+1];
        for(int i = 0; i < 2*len; i++) {
            ps[i+1] = ps[i] + nums[i%len];
        }
        //For given i, find max ps[i] - ps[j]; given constraint j -i <= len
        //Monotonic inreasing queue; i.e. dq.peekFirst() is smallest;
        Deque<Integer> dq = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for(int i = 0; i <= 2*len; i++) {
            while(!dq.isEmpty() && i-dq.peekFirst() > len) {
                dq.pollFirst();
            }
            if(!dq.isEmpty()) {
                res = Math.max(res, ps[i]-ps[dq.peekFirst()]);
            }
            while(!dq.isEmpty() && ps[dq.peekLast()] >= ps[i]) {
                dq.pollLast();
            }
            dq.offer(i);
        }
        return res;
    }
}
