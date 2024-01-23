package dynamicprogrammingadvanced;

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSumBottomUp(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        //base case
        for(int j=0;j<n;j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n;i++) {
            for(int j=0; j<n;j++) {
                if(j==0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j==n-1)  {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
                else if (j>0 && j<n-1) {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i-1][j+1]);
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n;i++) {
            if(dp[n-1][i] < min) {
                min = dp[n-1][i];
            }
        }
        return min;
    }
    public int minFallingPathSumTopDown(int n, int[][] matrix) {
        int[][] dp = new int[n][n];
        for(int[] e: dp) {
            Arrays.fill(e, -1);
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++) {
            int sum = minFallingPathSumHelper(n, matrix, 0, j, dp);
            min = Math.min(sum, min);
        }
        return min;
    }
    public int minFallingPathSumHelper(int n, int[][] matrix, int i, int j, int[][] dp) {
        if(i<0 || j < 0 || i >=n  || j >=n) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int sum = matrix[i][j];
        int[] x = {1, 1, 1};
        int[] y = {-1, 0, 1};
        int minSum = Integer.MAX_VALUE;
        for(int k=0;k<3;k++) {
            int nextI = i + x[k];
            int nextJ = j + y[k];
            int curSum = minFallingPathSumHelper(n, matrix, nextI, nextJ, dp);
            if(curSum != Integer.MAX_VALUE) {
                minSum = Math.min(curSum, minSum);
            }
        }
        if(minSum == Integer.MAX_VALUE) {
            return dp[i][j] = sum;
        }
        return dp[i][j] =  sum + minSum;
    }
}
