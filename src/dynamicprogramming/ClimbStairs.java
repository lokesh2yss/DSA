package dynamicprogramming;

import java.util.Arrays;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairsBottomUpOptimized(n));
    }
    public static int climbStairsTopDown(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsTopDownHelper(n, dp);
    }
    public static int climbStairsTopDownHelper(int n, int[] dp) {
        if(n==0 || n==1) return dp[n] = 1;
        if(n==2) return dp[n] = 2;
        if(dp[n] != -1) return dp[n];
        return dp[n] = climbStairsTopDownHelper(n-1, dp) + climbStairsTopDownHelper(n-2, dp) + climbStairsTopDownHelper(n-3, dp);
    }
    public static int climbStairsBottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
    public static int climbStairsBottomUpOptimized(int n) {
        if(n==0) return 1;
        if(n == 1) return 1;
        if(n==2) return 2;
        int first = 1;
        int second = 1;
        int third = 2;
        int ans = -1;
        for(int i=3;i<=n;i++) {
            ans = first + second + third;
            first = second;
            second = third;
            third = ans;
        }
        return ans;
    }
}
