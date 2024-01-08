package dynamicprogramming;

import java.util.Arrays;

public class RopeCuttingMaxProduct {
    public static void main(String[] args) {
        int n = 34;
        System.out.println(maxProductTopDown(n));
        System.out.println(maxproductBottomUp(n));
    }
    public static long maxproductBottomUp(int n) {
        if(n<=3) return n-1;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++) {
            long max = Integer.MIN_VALUE;
            for(int cut = 1; cut <i; cut++) {
                max = Math.max(max, cut*dp[i-cut]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
    public static long maxProductTopDown(int n) {
        if(n==1) return 0;
        if(n==2) return 2;
        if(n==3) return 2;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        long a =  maxProductHelper(n, dp);
        return a;
    }
    public static long maxProductHelper(int i, long[] dp) {
        if(i==1) return 1;
        if(i==2) return 2;
        if(i==3) return 3;
        if(dp[i] != -1) return dp[i];
        long max = Integer.MIN_VALUE;
        for(int cut=1; cut<i; cut++) {
            long curMaxProduct = (cut*maxProductHelper(i-cut, dp));
            max = Math.max(max, curMaxProduct);
        }
        return dp[i] = max;
    }
}
