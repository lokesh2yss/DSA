package dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println(editDistanceTopDown(s1, s2));
        System.out.println(editDistanceBottomUp(s1, s2));
    }
    public static int editDistanceBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++) {
            dp[0][j] = j;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int editDistanceTopDown(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] e: dp) {
            Arrays.fill(e, -1);
        }
        int minDist = minDistanceHelper(S1, S2, dp, n, m);

        return minDist;
    }
    public static int minDistanceHelper(String s1, String s2, int[][] dp, int i, int j) {
        if(i==0 && j==0) return dp[0][0] = 0;
        if(i==0) return dp[i][j] = j;
        if(j==0) return dp[i][j] = i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            dp[i][j] = minDistanceHelper(s1, s2, dp, i-1, j-1);
        }
        else {
            dp[i][j] = 1 + Math.min(Math.min(minDistanceHelper(s1, s2,dp, i-1, j), minDistanceHelper(s1, s2, dp, i, j-1)), minDistanceHelper(s1, s2, dp, i-1, j-1));
        }
        return dp[i][j];
    }
}
