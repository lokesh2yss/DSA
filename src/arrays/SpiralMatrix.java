package arrays;

public class SpiralMatrix {
    public int[][] spiralOrderMatrix(int n) {
        int r1 = 0;
        int r2 = n-1;
        int c1 = 0;
        int c2 = n-1;
        int val = 1;
        int[][] ans = new int[n][n];
        while(r1<=r2 && c1 <=c2) {
            //move left to right
            for(int c= c1; c<=c2; c++)  {
                ans[r1][c] = val++;
            }
            //move top-to-bottom
            for(int r=r1+1; r<=r2; r++) {
                ans[r][c2] = val++;
            }
            //move left and up only if r1<r2 and c1<c2
            if(r1<r2 && c1<c2) {
                //move left
                for(int c=c2-1; c>c1;c--) {
                    ans[r2][c] = val++;
                }
                //move up
                for(int r=r2; r>r1; r--) {
                    ans[r][c1] = val++;
                }

            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
