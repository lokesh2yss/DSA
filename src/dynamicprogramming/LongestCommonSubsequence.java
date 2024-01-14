package dynamicprogramming;

import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        //String s2 = "AGGTAB";
        //String s1 = "GXTXAYB";
        String s1 = "cab";
        String s2 = "abac";

        System.out.println(lcsStringBottomUp(s1, s2));
    }
    public static String lcsStringBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = n;
        int j = m;
        ArrayList<Integer> lcsIndicesI = new ArrayList<>();
        ArrayList<Integer> lcsIndicesJ = new ArrayList<>();
        while(i>0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.insert(0, s1.charAt(i - 1));
                lcsIndicesI.add(0,i-1);
                lcsIndicesJ.add(0,j-1);
                i--;
                j--;
            }
            else {
                if(dp[i][j] == dp[i-1][j]) {
                    i--;
                }
                else if(dp[i][j] == dp[i][j-1]) {
                    j--;
                }
                else {

                }
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(s2);

        int prev = 0;
        for(int k=0; k<lcsIndicesI.size();k++) {
            int end = lcsIndicesI.get(k);
            StringBuilder tmp = new StringBuilder();
            for(int l=prev;l<end;l++) {
                tmp.append(s1.charAt(l));
            }

            if(!tmp.isEmpty()) {
                ans.insert(lcsIndicesJ.get(k), tmp.toString());
            }
            //System.out.println("AAA"+lcsIndicesJ.get(k)+"AAA");
            int p = k;
            while(p<lcsIndicesJ.size()-1) {
                lcsIndicesJ.set(p + 1, lcsIndicesJ.get(p + 1) + tmp.length());
                p++;
                //System.out.println(lcsIndicesJ);
            }
            prev = end+1;
        }
        //System.out.println(lcsIndicesI);
        //System.out.println(lcsIndicesJ);
        return ans.toString();
    }
    public static int lcsBottomUpSpaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] dpA = new int[m+1];
        int[] dpB = new int[m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dpB[j] = dpA[j-1] + 1;
                }
                else {
                    dpB[j] = Math.max(dpB[i-1], dpA[j-1]);
                }
            }
            for(int k=0;k<=m;k++) {
                dpA[k] = dpB[k];
            }
        }
        return dpB[m];
    }
    public static int lcsBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int lcsTopDown(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] a: dp) {
            Arrays.fill(a,-1);
        }
        return lcsHelper(s1, s2, s1.length()-1, s2.length()-1,dp);
    }
    public static int lcsHelper(String s1, String s2, int i, int j, int[][] dp) {
        if(i <0  || j < 0) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1+ lcsHelper(s1, s2, i-1, j-1,dp);
        }
        return dp[i][j] = Math.max(lcsHelper(s1, s2, i-1, j,dp), lcsHelper(s1, s2, i,j-1,dp));
    }
    public static int longestCommonSubsequenceNaive(String s1, String s2) {
        ArrayList<String> a1 = subsequences(s1);
        ArrayList<String> a2 = subsequences(s2);
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<a1.size();i++) {
            for(int j=0;j<a2.size();j++) {
                if(a1.get(i).equals(a2.get(j))) {
                    maxLength = Math.max(maxLength, a1.get(i).length());
                }
            }
        }
        return maxLength;
    }
    public static ArrayList<String> subsequences(String s) {
        Set<String> ans = new HashSet<>();
        subsequenceHelper(s, 0, "",ans);
        return new ArrayList<>(ans);
    }
    public static void subsequenceHelper(String s, int i, String str, Set<String> ans) {
        ans.add(str);
        if(i==s.length()) return;
        subsequenceHelper(s, i+1, str, ans);
        subsequenceHelper(s, i+1, str+s.charAt(i), ans);

    }
}
