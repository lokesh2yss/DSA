package dynamicprogrammingadvanced;

public class CherryPickingII {
    public int cherryPickup(int n, int m, int[][] grid) {
        Integer[][][] dp = new Integer[n][m][m];
        return cherryPickupHelper(grid, n, m, 0, 0, m-1, dp);
    }
    public int cherryPickupHelper(int[][] grid, int n, int m, int r, int c1, int c2, Integer[][][] dp) {
        if(r>=n || c1 >= m  || c1 <0 || c2 >= m || c2 < 0) return Integer.MIN_VALUE;

        if(r == n-1) {
            if(c1==c2) {
                return grid[r][c1];
            }
            else {
                return grid[r][c1] + grid[r][c2];
            }
        }
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
        int cherries = 0;
        if(c1 ==c2) {
            cherries += grid[r][c1];
        }
        else {
            cherries += grid[r][c1] + grid[r][c2];
        }
        int[] a = {-1, 0, 1};
        int maxCherries = Integer.MIN_VALUE;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                maxCherries = Math.max(maxCherries, cherryPickupHelper(grid, n, m, r+1, c1+ a[i], c2 + a[j], dp));
            }
        }
        return dp[r][c1][c2] = maxCherries + cherries;
    }
}
