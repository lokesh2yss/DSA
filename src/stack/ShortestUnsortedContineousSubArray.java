package stack;

import java.util.ArrayDeque;

public class ShortestUnsortedContineousSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int left = n-1;
        for(int i =0 ;i< n;) {
            if(stack.isEmpty()) {
                stack.push(i);
                i++;
            }
            else {
                if(nums[stack.peek()] > nums[i]) {
                    left = Math.min(left, stack.peek());
                    stack.pop();
                }
                else {
                    stack.push(i);
                    i++;
                }
            }
        }

        stack.clear();
        int right = 0;
        for(int i = n-1 ;i >=0;) {
            if(stack.isEmpty()) {
                stack.push(i);
                i--;
            }
            else {
                if(nums[stack.peek()] < nums[i]) {
                    right = Math.max(right, stack.peek());
                    stack.pop();
                }
                else {
                    stack.push(i);
                    i--;
                }
            }
        }

        if (left>= right) {
            return 0;
        }
        return right-left+1;


    }
}
