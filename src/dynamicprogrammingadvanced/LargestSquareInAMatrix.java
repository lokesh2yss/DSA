package dynamicprogrammingadvanced;

public class LargestSquareInAMatrix {
    public static int maxSquare(int n, int m, int mat[][]){
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) {
            dp[i][0] = mat[i][0];
        }
        for(int j=0;j<m;j++) {
            dp[0][j] = mat[0][j];
        }
        int max = mat[0][0];
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(mat[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1; //dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
