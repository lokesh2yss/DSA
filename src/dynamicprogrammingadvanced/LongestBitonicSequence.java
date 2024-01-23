package dynamicprogrammingadvanced;

import java.util.*;

public class LongestBitonicSequence {
    public static void main(String[] args) {
        int[] a = {20, 7, 9, 6, 9, 21, 12, 3, 12, 16, 1, 27};
        System.out.println(longestBitonicSequence(a));
    }
    public static int longestBitonicSequence(int[] a){
        int n = a.length;
        int[] dp = new int[n];
        int[] lis = LISBottomUp(a);
        int[] lds = LDSBottomUp(a);
        for(int k=0;k<=n-1;k++) {
            dp[k] = lis[k] + lds[k] -1;
        }
        int max = Integer.MIN_VALUE;
        for(int e: dp) {
            max = Math.max(max, e);
        }
        return max;
    }

    public static int[] LISBottomUp(int[] a) {
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
        return dp;
    }
    public static int[] LDSBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=n-2;i>=0;i--) {
            for(int j=n-1; j>i; j--) {
                if(a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp;
    }
}
