package dynamicprogrammingadvanced;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int matrixMultiplicationTopDown(int[] arr, int N) {
        int[][] dp = new int[N][N];
        for(int[] e: dp) {
            Arrays.fill(e, -1);
        }
        return matrixMultiplicationTopDownHelper(arr, N, 1, N-1, dp);
    }
    public static int matrixMultiplicationTopDownHelper(int[] arr, int N, int i, int j, int[][] dp) {
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int minOps = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int operations = arr[i-1]*arr[k]*arr[j] +
                    matrixMultiplicationTopDownHelper(arr, N, i, k, dp) +
                    matrixMultiplicationTopDownHelper(arr, N, k+1, j,dp);
            minOps = Math.min(minOps, operations);
        }
        return dp[i][j] = minOps;
    }
    public static int matrixMultiplicationBottomUp(int arr[], int N)
    {
        int[][] dp = new int[N][N];
        for(int i=1;i<N;i++) dp[i][i] = 0;
        for(int i=N-1;i>=1;i--) {
            for(int j = i+1; j<N;j++) {
                int minMultiplications = Integer.MAX_VALUE;
                for(int k=i;k<j;k++) {
                    int minOps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    minMultiplications = Math.min(minMultiplications, minOps);
                }
                dp[i][j] = minMultiplications;
            }
        }
        return dp[1][N-1];
    }
}
