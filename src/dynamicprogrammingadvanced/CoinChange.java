package dynamicprogrammingadvanced;
import java.util.*;
public class CoinChange {
    public static void main(String[] args) {
        int[] a = {5,1, 8};
        int amount = 13;
        System.out.println(coinChangeBottomUp(a, amount));
    }
    public static int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1;i<=amount;i++) {
            int minCoins = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++) {
                if(i-coins[j] >=0) {
                  minCoins = Math.min(minCoins, 1 + dp[i-coins[j]]);
                }
            }
            dp[i] = minCoins;
        }
        return dp[amount];
    }
    public int coinChangeTopDown(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int minCoins = coinChangeHelper(coins, amount, dp);
        return minCoins==Integer.MAX_VALUE?-1:minCoins;
    }
    public int coinChangeHelper(int[] coins, int amount, int[] dp) {
        int n = coins.length;
        if(amount == 0) return 0;
        if(amount <0) return Integer.MAX_VALUE;
        if(dp[amount] !=-1) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int subAns = coinChangeHelper(coins, amount - coins[i], dp);
            if(subAns != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + subAns);
            }
        }
        return dp[amount] = minCoins;
    }
}
