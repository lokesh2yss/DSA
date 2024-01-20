package queue;
import java.util.*;
public class MinimumConsecutiveKBitFlipsSecond {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(((q.size()&1) ==0 && nums[i] == 0) || ((q.size()&1) != 0 && nums[i] == 1)) {
                if(i+k-1 >=n) return -1;
                q.offer(i+k-1);
                count++;
            }
            if(!q.isEmpty() && q.peek() == i) {
                q.poll();
            }
        }
        return count;
    }
}
