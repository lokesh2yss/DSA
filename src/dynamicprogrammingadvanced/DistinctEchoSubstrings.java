package dynamicprogrammingadvanced;

public class DistinctEchoSubstrings {
    public static void main(String[] args) {
        String s = "abcabcabc";
    }
    public int countDistinctEchoSubstrings(String text) {
        int n = text.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(text.charAt(i-1) == text.charAt(j-1) && i-1 != j-1) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=n;i>=0;i--) {
            for(int j=n;j>=0;j--) {
                //if(dp[i-1][j-1] !=0)
            }
        }
        return dp[n][n];
    }
}
