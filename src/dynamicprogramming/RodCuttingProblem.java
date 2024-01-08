package dynamicprogramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] prices = {1,5,8,9,10, 17, 17, 20};
        System.out.println(maxPrice(prices));
        System.out.println(rodCuttingProblemBottomUp(prices.length, prices));

    }
    public static int maxPrice(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return maxPriceHelper(prices, dp, n, n);
    }
    public static int maxPriceHelper(int[] prices, int[] dp, int n, int i) {
        if(i <=0) return dp[0] = 0;
        if(dp[i] != -1) return dp[i];
        int max = Integer.MIN_VALUE;
        for(int len=1;len<=i;len++) {
            int maxProfitAtThisCut = prices[len-1] + maxPriceHelper(prices, dp, n, i-len);
            max = Math.max(max, maxProfitAtThisCut);
        }
        return dp[i] = max;
    }
    public static int rodCuttingProblemBottomUp(int n, int[] prices) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = prices[0];
        for(int i=2;i<=n;i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j <i;j++) {
                max = Math.max(max, prices[j] + dp[i-j-1]);

            }
            dp[i] = max;
        }
        return dp[n];
    }
}
