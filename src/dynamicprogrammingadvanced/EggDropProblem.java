package dynamicprogrammingadvanced;
import java.util.*;
public class EggDropProblem {
    public static void main(String[] args) {
        System.out.println(eggDropTopDown(2, 10));
    }

    public static int eggDropTopDown(int n, int k) {
        int[][] dp = new int[n][k+1];
        for(int[] e: dp) {
            Arrays.fill(e, -1);
        }
        return eggDropTopDownHelper(n, k, dp);
    }
    public static int eggDropTopDownHelper(int eggs, int floors, int[][] dp) {
        //System.out.println("eggs="+eggs+", floors="+floors);
        if(eggs == 1) return floors;
        if(floors == 1) return 1;
        if(floors == 0) return 0;
        if(dp[eggs-1][floors] != -1) return dp[eggs-1][floors];
        int min = Integer.MAX_VALUE;
        for(int floor = 1; floor<=floors; floor++) {
            min = Math.min(min, 1 + Math.max(eggDropTopDownHelper(eggs-1,floor-1, dp),
                    eggDropTopDownHelper(eggs, floors-floor, dp)));
        }
        return dp[eggs-1][floors] = min;
    }
    public static int eggDropBottomUp(int n, int k)
    {
        int[][] dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int i=0;i<=k;i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        for(int eggs=2;eggs<=n;eggs++) {
            for(int floors=2; floors <=k; floors++) {
                int min = Integer.MAX_VALUE;
                for(int l=1;l<=floors;l++) {
                    min = Math.min(min, 1 + Math.max(dp[eggs-1][l-1], dp[eggs][floors-l]));
                }
                dp[eggs][floors] = min;
            }
        }
        return dp[n][k];
    }
}
