package trieandstrings;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String t = "abcadabcabcababcab";
        String p = "abcab";
        //System.out.println(Arrays.toString(lps(p)));
        System.out.println(matchPattern(t,p));
    }
    public static ArrayList<Integer> matchPattern(String t, String p) {
        int n = t.length();
        int m = p.length();
        int[] lps = lps(p);
        ArrayList<Integer> ans = new ArrayList<>();
        int i=1, j=0;
        while(i<n) {
            if(t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if(j==m) {
                    ans.add(i-m);
                    j=lps[j-1];
                }

            }
            else {
                if(j==0) i++;
                else {
                    j = lps[j-1];
                }
            }
        }
        return ans;
    }
    public static int[] lps(String S) {
        int n = S.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int p=0,  s=1;
        while(s <n) {
            if(S.charAt(p) == S.charAt(s)) {
                lps[s] = p+1;
                s++;
                p++;
            }
            else {
                if(p==0) s++;
                else {
                    p = lps[p-1];
                }
            }
        }
        return lps;
    }
}
