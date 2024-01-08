package stack2;

import java.util.ArrayDeque;

public class ShortestUnsortedContinuousSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int left = n-1;
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        int right = 0;
        for(int i=n-1; i>=0;i--) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        if(left >=right) return 0; //array is already sorted
        return right -left +1;
    }
}
