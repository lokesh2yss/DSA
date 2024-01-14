package queue;
import java.util.*;
public class ContinuousSubArrays {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> minQ = new ArrayDeque<>();
        ArrayDeque<Integer> maxQ = new ArrayDeque<>();
        int l=0;
        int r =0;
        long ans = 0;
        while(r<n) {
            while(!minQ.isEmpty() && nums[r] < minQ.peekLast()) {
                minQ.pollLast();
            }
            while(!maxQ.isEmpty() && nums[r] > maxQ.peekLast()) {
                maxQ.pollLast();
            }
            minQ.offerLast(nums[r]);
            maxQ.offerLast(nums[r]);
            while(maxQ.peekFirst() - minQ.peekFirst() > 2) {
                if(maxQ.peekFirst() == nums[l]) {
                    maxQ.pollFirst();
                }
                if(minQ.peekFirst() == nums[l]) {
                    minQ.pollFirst();
                }
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
}
