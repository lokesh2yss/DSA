package dynamicprogramming;
public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        //String s2 = "abac";
        //String s1 = "cab";
        String s = shortestCommonSuperSequence(s1, s2);
        System.out.println(s);

    }
    public static String shortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int i = n;
        int j = m;
        StringBuilder ans = new StringBuilder();
        while(i>=1 && j >=1) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    ans.append(s1.charAt(i - 1));
                    i--;
                    j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    ans.append(s1.charAt(i-1));
                    i--;
                }
                else {
                    ans.append(s2.charAt(j-1));
                    j--;
                }
            }
        }
        while(j> 0) {
            ans.append(s2.charAt(j-1));
            j--;
        }
        while(i>0) {
            ans.append(s1.charAt(i-1));
            i--;
        }
        return ans.reverse().toString();
    }
}
