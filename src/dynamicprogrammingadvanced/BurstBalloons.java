package dynamicprogrammingadvanced;
import java.util.*;
public class BurstBalloons {
    public int maxCoins(int[] Nums) {
        return maxCoinsTopDown(Nums);
    }
    public int maxCoinsBottomUp(int[] Nums) {
        int n = Nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=0;i<n;i++) list.add(Nums[i]);
        list.add(1);
        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--) {
            for(int j=1; j<=n;j++) {
                if(i > j) continue;
                int maxCoins = Integer.MIN_VALUE;
                for(int index = i; index <=j;index++) {
                    int earnedCoins = list.get(i-1)*list.get(index)*list.get(j+1) +
                            dp[i][index-1] + dp[index+1][j];
                    maxCoins = Math.max(maxCoins, earnedCoins);
                }
                dp[i][j] = maxCoins;
            }
        }
        return dp[1][n];
    }
    public int maxCoinsTopDown(int[] Nums) {
        int n = Nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=0;i<n;i++) list.add(Nums[i]);
        list.add(1);
        int[][] dp = new int[n+1][n+1];
        for(int[] e: dp) {
            Arrays.fill(e,-1);
        }
        return maxCoinsHelper(list, 1, n, dp);
    }
    public int maxCoinsHelper(ArrayList<Integer> list, int i, int j, int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int maxCoins = Integer.MIN_VALUE;
        for(int index=i; index<=j;index++) {
            int earnedCoins = list.get(i-1)*list.get(index)*list.get(j+1) +
                    maxCoinsHelper(list, i, index-1, dp) +
                    maxCoinsHelper(list, index+1, j, dp);
            maxCoins = Math.max(earnedCoins, maxCoins);
        }
        return dp[i][j] = maxCoins;
    }
}
