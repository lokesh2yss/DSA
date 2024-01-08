package dynamicprogramming;

import java.util.Arrays;

public class HouseRobberProblem {
    public static void main(String[] args) {
        int[] a = {6,7,1,3,8,2,4};
        //int[] a = {5,3,4,11,2};
        System.out.println(maxStealTopDown(a));
        System.out.println(maxStealBottomUp(a));

    }
    public static int maxStealTopDown(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxStealTopDownHelper(a, dp, n-1);
    }
    public static int maxStealTopDownHelper(int[] a, int[] dp, int i) {
        if(i < 0) return 0;
        if(i==0) return a[0];
        //if(n==1) return a[0];
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.max(maxStealTopDownHelper(a, dp, i-2) + a[i], maxStealTopDownHelper(a, dp, i-1));
    }
    public static int maxStealBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        for(int i=2;i<n;i++) {
            dp[i] = Math.max(dp[i-2] + a[i], dp[i-1]);
        }
        return dp[n-1];
    }
}
