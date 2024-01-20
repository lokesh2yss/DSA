package queue;
import java.util.*;
public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            if((q.size() & 1) != 0) { //queue size is odd
                nums[i] = nums[i] ^ 1; //invert the bit
            }
            if(nums[i] == 0) {
                if(i+k > n) {
                    return -1;
                }
                count++;
                q.offer(i+k-1);
            }
            if(!q.isEmpty() && q.peek() == i) {
                q.poll();
            }
        }

        return count;
    }
}
