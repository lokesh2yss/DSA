package arrays;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int zeroCount = 0;
        int sX = 0;
        int sY = 0;
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    zeroCount++;
                }
                else if(grid[i][j] ==1) {
                    sX = i;
                    sY = j;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];

        return findUniquePaths(grid, visited, sX, sY,m,n,zeroCount);
    }
    public int findUniquePaths(int[][] grid, boolean[][] visited, int i, int j, int m, int n, int zeroCount ) {
        if(i<0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j]== -1) {
            return 0;
        }
        if(grid[i][j] ==2) {
            return zeroCount == -1?1:0;
        }
        visited[i][j] = true;
        zeroCount--;
        int pathsCount = findUniquePaths(grid,visited,i+1,j,m,n,zeroCount) +
                findUniquePaths(grid,visited,i-1,j,m,n,zeroCount) +
                findUniquePaths(grid,visited,i,j+1,m,n,zeroCount) +
                findUniquePaths(grid,visited,i,j-1,m,n,zeroCount);
        visited[i][j] = false;
        zeroCount++;
        return pathsCount;
    }

}
