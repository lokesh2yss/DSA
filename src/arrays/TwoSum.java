package arrays;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] numsCopy = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(nums);
        int  l = 0;
        int r = nums.length-1;

        while(l<r) {
            int sum = nums[l] + nums[r];
            System.out.println(sum);
            if(sum == target) {
                return findIndices(numsCopy, nums[l], nums[r]);
            }
            else if(sum < target) {
                l++;
            }
            else {
                r--;
            }
        }

        return new int[] {-1,-1};
    }
    public int[] findIndices(int[] nums, int a, int b) {
        int[] ans = new int[2];
        for(int i =0; i< nums.length; i++) {
            if(nums[i] == a) {
                ans[0] = i;
                continue;
            }
            if(nums[i] == b) {
                ans[1] = i;
                continue;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
    public void printArray(int[] a) {
        for(int i: a) {
            System.out.print(i+ " ");
        }
    }
}
