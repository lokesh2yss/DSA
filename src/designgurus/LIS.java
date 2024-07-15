package designgurus;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] a = {2,9,4,6,10,5};
        System.out.println(lisBottomUp(a));
    }
    public static int lisBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n;i++) {
            for(int j=0; j<i;j++) {
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        int ans = 0;
        for(int e: dp) {
            ans = Math.max(ans, e);
        }
        return ans;
    }
    public static int lis(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        lisUtil(a, n-1, dp);
        int ans = 0;
        for(int e: dp) {
            ans = Math.max(ans, e);
        }
        return ans;
    }
    public static int lisUtil(int[] a, int index, int[] dp) {
        if(index ==0) return 1;
        if(dp[index] != -1) return dp[index];
        int max = 1;
        for(int i=0;i<index;i++) {
            int lisI = lisUtil(a, i, dp);
            if(a[index] > a[i]) {
                max = Math.max(max, 1 + lisI);
            }
        }
        return dp[index] = max;
    }
}
