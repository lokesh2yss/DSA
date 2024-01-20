package dynamicprogrammingadvanced;

import java.util.Arrays;

public class UniquePathsInGrid {
    public static final int MOD = 1000000007;
    public static int uniquePathsTopDown(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] e :  dp) Arrays.fill(e, -1);
        return uniquePathsTopDownHelper(m-1, n-1, dp);
    }
    public static int uniquePathsTopDownHelper(int i, int j, int[][] dp) {
        if(i==0 || j==0 ) return 1;
        if(dp[i][j] !=-1) return dp[i][j];
        return dp[i][j] = uniquePathsTopDownHelper(i-1, j, dp) + uniquePathsTopDownHelper(i, j-1, dp);

    }
    public static int uniquePathsBottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) dp[i][0] = 1;
        for(int i=0;i<n;i++) dp[0][i] = 1;
        for(int i =1; i<m;i++) {
            for(int j=1; j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1]%MOD;
    }
}
