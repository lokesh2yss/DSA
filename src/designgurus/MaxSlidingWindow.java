package designgurus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(a, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int windowStart = 0;
        int curWindowMax = Integer.MIN_VALUE;
        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            int cur = nums[windowEnd];
            while(!dq.isEmpty() && cur >= dq.peekLast()) {
                dq.pollLast();
            }
            dq.offerLast(cur);
            curWindowMax = Math.max(curWindowMax, cur);
            if(windowEnd >= k -1) {
                ans[windowStart] = curWindowMax;
                int left = nums[windowStart];
                if(left == curWindowMax && !dq.isEmpty() && dq.peekFirst() == left) {
                    dq.pollFirst();
                    curWindowMax = dq.peekFirst();
                }
                windowStart++;
            }
        }
        return ans;
    }
}
