package queue;
import java.util.*;
public class SlidingWindowMaximum {
    public static List<Integer> maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        //fill the empty dq with first k elements
        int i=0;
        while(i<k) {
            while(!dq.isEmpty() && dq.getLast() < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
            i++;
        }
        //now loop over the remaining elements
        for(;i<n;i++) {
            ans.add(dq.peekFirst());
            if(nums[i-k] == dq.peekFirst()) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast() < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
        }
        ans.add(dq.peekFirst());
        return ans;

    }

}
