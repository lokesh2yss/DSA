package recursion;

public class KnightTour {
    public static int[][] knightTour(int n, int m) {
        int[] moveX = {1,-1,-2,-2,-1,1,2,2};
        int[] moveY = {2,2,1,-1,-2,-2,-1,1};
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                ans[i][j] = -1;
            }
        }
        ans[0][0] = 0;
        boolean isTourCompleted  = knightTourHelper(n,m,ans, moveX, moveY,0,0,1);
        if(isTourCompleted == false) {
            ans[0][0] = -1;
        }
        return ans;

    }
    public static boolean knightTourHelper(int n, int m, int[][] ans, int[] moveX, int[] moveY, int i, int j, int step) {
        if(step== n*m) return true;
        for(int k=0;k<8;k++) {
            int nextX = i + moveX[k];
            int nextY = j + moveY[k];
            if(isValid(nextX,nextY,ans, n, m)) {
                ans[nextX][nextY]  = step;
                boolean isTourCompleted  = knightTourHelper(n, m, ans, moveX, moveY,nextX,nextY, step+1);
                if(isTourCompleted==true) {
                    return true;
                }
                else {
                    ans[nextX][nextY]  = -1;
                }
            }
        }
        return false;
    }
    public static boolean isValid(int i, int j, int[][] ans, int n, int m) {
        return i >=0 && j >= 0 && i < n && j < m && ans[i][j] == -1;
    }
}
