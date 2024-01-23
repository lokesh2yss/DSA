package dynamicprogrammingadvanced;

public class CherryPickingI {

    public int cherryPickupTopDown(int[][] grid) {
        int n = grid.length;
        Integer[][][][] dp = new Integer[n][n][n][n];
        int ans =  cherryPickupTopDownHelper(grid, 0,0,0,0,dp);
        return Math.max(0, ans);
    }
    public int cherryPickupTopDownHelper(int[][] grid, int r1, int c1, int r2, int c2, Integer[][][][] dp) {
        int n = grid.length;
        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1) return Integer.MIN_VALUE;
        if(dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];
        if(r1==n-1 && c1 ==n-1) {
            return grid[r1][r2];
        }

        int cherries = 0;
        if(r1 == r2 && c1==c2) {
            cherries += grid[r1][c1];
        }
        else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        int val1 = cherryPickupTopDownHelper(grid, r1+1, c1, r2+1, c2, dp);
        int val2 = cherryPickupTopDownHelper(grid, r1+1, c1, r2, c2+1, dp);
        int val3 = cherryPickupTopDownHelper(grid, r1, c1+1, r2+1, c2, dp);
        int val4 = cherryPickupTopDownHelper(grid, r1, c1+1, r2, c2+1, dp);
        cherries += Math.max(Math.max(val1, val2), Math.max(val3,val4));
        return dp[r1][c1][r2][c2] = cherries;
    }
}
