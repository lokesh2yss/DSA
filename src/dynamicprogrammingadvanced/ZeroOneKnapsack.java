package dynamicprogrammingadvanced;

import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] values = {30, 40, 60};//{30, 20, 50, 70};
        int[] weights = {1, 2, 3}; //{6, 4, 10, 7};
        int W = 5;//11;
        System.out.println(zeroOneKnapsackTopDown(W, values, weights));
        System.out.println(zeroOneKnapsackBottomUp(W, values, weights));
    }
    public static int zeroOneKnapsackTopDown(int W, int[] v, int[] w) {
        int n = v.length;
        int[][] dp = new int[W+1][n];
        for(int[] e: dp ) {
            Arrays.fill(e,-1);
        }
        return zeroOneKnapsackTopDownHelper(W, v, w, n-1,dp);
    }
    public static int zeroOneKnapsackTopDownHelper(int W, int[] v, int[] w, int index, int[][] dp) {
        if(index == -1) return 0;
        if(dp[W][index] !=-1) return dp[W][index];
        int ithItemNotTaken = zeroOneKnapsackTopDownHelper(W, v, w, index-1,dp);
        int ithItemTaken = 0;
        if(W >= w[index]) {
            ithItemTaken = v[index] + zeroOneKnapsackTopDownHelper(W-w[index], v, w, index-1,dp);
        }
        return dp[W][index] = Math.max(ithItemTaken, ithItemNotTaken);
    }
    public static int zeroOneKnapsackBottomUp(int W, int[] v, int[] w) {
        int items = v.length;
        int[][] dp = new int[items+1][W+1];
        for(int i=1; i<=items;i++) {
            for(int curCapacity=1; curCapacity<=W;curCapacity++) {
                if(w[i-1] > curCapacity) {
                    dp[i][curCapacity] = dp[i-1][curCapacity];
                }
                else {
                    int notTake = dp[i - 1][curCapacity];
                    int take = v[i - 1] + dp[i-1][curCapacity-w[i-1]];

                    dp[i][curCapacity] = Math.max(take, notTake);
                }
            }
        }
        return dp[items][W];
    }
}
