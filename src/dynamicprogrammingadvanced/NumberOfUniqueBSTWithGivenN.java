package dynamicprogrammingadvanced;

import java.util.Arrays;

public class NumberOfUniqueBSTWithGivenN {
    public static int numberOfBST(int n)
    {
        return numberOfBSTBottomUp(n);
    }
    public static int numberOfBSTTopDown(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return numberOfBSTTopDownHelper(n, dp);
    }
    public static int numberOfBSTTopDownHelper(int n, int[] dp) {
        if(n==0) return 1;
        if(dp[n] != -1) return dp[n];
        int totalBSTs = 0;
        for(int i=1;i<=n;i++) {
            totalBSTs += numberOfBSTTopDownHelper(i-1,dp)*numberOfBSTTopDownHelper(n-i,dp);
        }
        return dp[n] = totalBSTs;
    }
    public static int numberOfBSTBottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=1;i<=n;i++) {
            int count = 0;
            for(int j=1; j<=i;j++) {
                count += dp[j-1]*dp[i-j];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
