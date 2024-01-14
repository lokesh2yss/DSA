package graph;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        int[][] matrix2 = {
                {9, 9, 4},
                {6, 6, 9},
                {2, 1, 1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dp = new int[m][n];
        for(int[] e: dp) {
            Arrays.fill(e, -1);
        }
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<m;i++) {
            for(int j=0; j< n; j++) {
                if(dp[i][j] == -1) {
                    maxLength = Math.max(maxLength, dfs(matrix, i, j, visited, dp, 1));
                }
            }
        }
        return maxLength;
    }
    public static int dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] dp, int length) {
        if(dp[i][j] != -1) return dp[i][j];
        visited[i][j] = true;
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        System.out.println("i="+i+", j="+j);
        int maxLength = 1;
        for(int k=0;k<4;k++) {
            int nextI = i + x[k];
            int nextJ = j + y[k];
            if(isSafe(matrix, nextI, nextJ, visited) && matrix[nextI][nextJ] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, nextI, nextJ, visited, dp,length+1));
            }
        }
        visited[i][j] = false;
        return dp[i][j] = maxLength;
    }
    public static boolean isSafe(int[][] matrix, int i, int j, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        return i>=0 && i<m && j>=0 && j<n && !visited[i][j];
    }

}
