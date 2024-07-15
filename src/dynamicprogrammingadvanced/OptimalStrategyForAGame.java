package dynamicprogrammingadvanced;

import java.util.Arrays;

public class OptimalStrategyForAGame {
    public static long countMaximum(int arr[], int n){
        long[][] dp = new long[n][n];
        for(long[] e: dp) Arrays.fill(e,-1);
        long ans =  countMaximumHelper(arr, n, 0, n-1,dp);

        return ans;
    }
    public static long countMaximumHelper(int[] arr, int n, int i, int j, long[][] dp) {
        if(j<i) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        long x = arr[i] + Math.min(countMaximumHelper(arr, n, i+2, j, dp), countMaximumHelper(arr, n, i+1, j-1, dp));
        long y = arr[j] + Math.min(countMaximumHelper(arr, n,  i+1, j-1, dp), countMaximumHelper(arr, n, i, j-2, dp ));
        return dp[i][j] = Math.max(x, y);
    }
}
