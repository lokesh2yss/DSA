package dynamicprogramming;

import java.util.Arrays;

public class TilingProblem {
    public static void main(String[] args) {
        int n = 185;
        System.out.println(tilingProblemTopDown(n));
        System.out.println(tilingProblemBottomUp(n));
    }
    public static int tilingProblemTopDown(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return tilingProblemTopDownHelper(n, dp);
    }
    public static int tilingProblemTopDownHelper(int n, int[] dp) {
        if(n==0) return dp[0] = 1;
        if(n==1) return dp[1] = 1;
        if(n==2) return dp[2] = 2;
        if(dp[n] != -1) return dp[n];
        return dp[n] = tilingProblemTopDownHelper(n-1, dp) + tilingProblemTopDownHelper(n-2, dp);
    }
    public static int tilingProblemBottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
