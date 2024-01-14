package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] a = {2, 9, 4, 6, 10, 5};
        System.out.println(LIS(a));
        System.out.println(LISBottomUp(a));
    }
    public static int LIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        LISHelper(a, dp, n-1);
        int max = Integer.MIN_VALUE;
        for(int x: dp) {
            //System.out.println(x);
            max = Math.max(x, max);
        }
        return max;
    }
    public static int LISHelper(int[] a, int[] dp, int index) {
        if(index == 0) return dp[0] = 1;
        if(dp[index] != -1) return dp[index];
        int max = 1;
        for(int i=index-1; i>=0;i--) {
            int ansAtI = LISHelper(a, dp, i);
            if(a[i] < a[index]) {
                max = Math.max(max, 1 + ansAtI);
            }
        }
        return dp[index] = max;
    }
    public static int LISBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++) {
            for(int j=0; j<i; j++) {
                if(a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = 1;
        for(int e: dp) {
            max = Math.max(e, max);
        }
        return max;
    }
}
