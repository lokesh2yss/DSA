package dynamicprogrammingadvanced;

import java.util.Arrays;

public class PalindromicPartitioningII {
    public static int palindromicPartitioningIIBottomUp(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        boolean[][] pal = new boolean[n][n];
        fillPalindromeMatrix(s, pal, n);
        dp[n] = 0;
        for(int i=n-1;i>=0;i--) {
            int min = Integer.MAX_VALUE;
            for(int j=i;j<n;j++) {
                //if(isPalindrome(s, i, j)) {
                if(pal[i][j]) {
                    int minCost = 1 + dp[j+1];
                    min = Math.min(min, minCost);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }
    public static void fillPalindromeMatrix(String s, boolean[][] pal, int n) {
        for(int i=0;i<n;i++) pal[i][i] = true;
        for(int len = 2; len <=n;len++) {
            for(int i=0;i<=n-len;i++) {
                int j = len + i -1;
                if(s.charAt(i) == s.charAt(j) && (pal[i+1][j-1] || len==2)) {
                    pal[i][j] = true;
                }
            }
        }
    }

    public static int palindromicPartitioningIITopDown(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return palindromicPartitioningIITopDownHelper(s, 0, n, dp) -1;
    }
    public static int palindromicPartitioningIITopDownHelper(String s, int i, int n, int[] dp) {
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j=i; j<n;j++) {
            if(isPalindrome(s, i, j)) {
                min = Math.min(min, 1 + palindromicPartitioningIITopDownHelper(s, j+1, n, dp));
            }
        }
        return dp[i] = min;
    }
    public static boolean isPalindrome(String s, int l, int r) {
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
