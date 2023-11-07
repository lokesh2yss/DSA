package arrays;

public class MinLengthSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6,7, 2};
        int target = 7;
        System.out.println(minSumSubArray(nums,target));
    }
    public static int minSumSubArray(int[] nums, int target) {
        int n = nums.length;
        int minSize = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(left <= right && left< n && right < n) {
            int sum = windowSum(nums, left, right);
            if (sum >= target) {
                minSize = Math.min(minSize,right-left+1);
                left++;
            }
            if(sum < target) {
                right++;
            }
        }
        return minSize;

    }
    public static int windowSum(int[] nums, int l, int r) {
        int sum = 0;
        for(int i = l; i<=r; i++) {
            sum += nums[i];
        }
        return sum;
    }
    public static int minSumSubArrayBF(int[] nums, int target) {
        int n = nums.length;
        int[] CS = new int[n];
        CS[0] = nums[0];
        for(int i = 1; i< n; i++) {
            CS[i] = CS[i-1] + nums[i];
        }

        int minSize = Integer.MAX_VALUE;
        for(int i=0; i< n; i++) {
            for(int j= i; j<n; j++) {
                int sumIToJ;
                if(i==0) {
                    sumIToJ = CS[j];
                }
                else {
                    sumIToJ = CS[j] - CS[i-1];
                }
                if(sumIToJ >= target) {
                    minSize = Math.min(minSize, j-i+1);
                }
            }
        }
        return minSize;
    }
}
