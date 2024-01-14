package dynamicprogramming;

import java.util.Arrays;

public class MinimumInsertionDeletion {
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        System.out.println(insertDeleteBottomUp(s1, s2));
        System.out.println(insertDeleteTopDown(s1, s2));
    }
    public static int insertDeleteTopDown(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] e: dp) {
            Arrays.fill(e, -1);
        }
        return insertDeleteTopDownHelper(s1, s2, n-1, m-1, dp);
    }
    public static int insertDeleteTopDownHelper(String s1, String s2, int i, int j, int[][] dp) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = insertDeleteTopDownHelper(s1, s2, i-1, j-1, dp);
        }
        else {
            return dp[i][j] = 1 + Math.min(insertDeleteTopDownHelper(s1, s2, i-1, j, dp), insertDeleteTopDownHelper(s1, s2, i, j-1, dp));
        }
    }
    public static int insertDeleteBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++) {
            dp[0][i] = i;
        }
        for(int j=0;j<=m;j++) {
            dp[j][0] = j;
        }
        for(int i=1; i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s1.charAt(j-1) == s2.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        for(int[] e: dp) {
            System.out.println(Arrays.toString(e));
        }
        return dp[m][n];
    }
}
