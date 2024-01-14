package dynamicprogramming;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {2, 9, 4, 6, 10, 5};
        System.out.println(maxSumISTopDown(a));
        System.out.println(maxSumISBottomUp(a));
    }
    public static int maxSumISBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        for(int i=1;i<n;i++) {
            for(int j=0; j<i;j++) {
                if(a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], a[i] + dp[j]);
                }
            }
        }
        int max = 0;
        for(int e: dp) {
            max = Math.max(max, e);
        }
        return max;
     }
    public static int maxSumISTopDown(int arr[])
    {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int max = Integer.MIN_VALUE;
        maxSumIncreasingsubsequence(arr, n-1, dp);
        for(int e: dp) {
            max = Math.max(max, e);
        }
        return max;
    }
    public static int maxSumIncreasingsubsequence(int[] a, int index, int[] dp) {
        if(index == 0) return dp[0] = a[0];
        if(dp[index] != -1) return dp[index];
        int maxSum = a[index];
        for(int i=index-1;i>=0;i--) {
            int maxSumTillI = maxSumIncreasingsubsequence(a, i, dp);
            if(a[i] < a[index]) {
                maxSum = Math.max(maxSum, a[index] + maxSumTillI);
            }
        }
        return dp[index] = maxSum;
    }
}
