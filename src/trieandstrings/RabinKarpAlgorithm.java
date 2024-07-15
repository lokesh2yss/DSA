package trieandstrings;

import java.util.ArrayList;

public class RabinKarpAlgorithm {
    public static final int M = (int) 1e9+7;
    public static final int CHAR_SIZE = 26;
    public static void main(String[] args) {
        String s= "abcdabcedabc";
        String p = "dabc";
        System.out.println(rabinKarpMatch(s,p));
    }
    public static ArrayList<Integer> rabinKarpMatch(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int hs = rollingHash(s, m);
        int hp = rollingHash(p, m);
        for(int i=m;i<n;i++) {
            if (hs == hp) {
                if (isExactMatch(s,i-m, p)) {
                    ans.add(i-m);
                }
            }
            hs -= (int) (Math.pow(CHAR_SIZE, m-1)%M*(s.charAt(i-m)-'a'+1)%M);
            hs *= CHAR_SIZE;
            hs += s.charAt(i) - 'a' +1;
        }
        if(hp == hs) {
            if(isExactMatch(s, n-m, p)) {
                ans.add(n-m);
            }
        }
        return ans;
    }
    public static boolean isExactMatch(String s, int index, String p) {
        int m = p.length();
        for(int i=0;i<m;i++) {
            if(s.charAt(index+i) != p.charAt(i)) return false;
        }
        return true;
    }
    public static int rollingHash(String s, int size) {
        int hash  = 0;
        for(int i=0;i<size;i++) {
            hash += (int) ((Math.pow(CHAR_SIZE, size-i-1)%M*(s.charAt(i) -'a' +1))%M);
        }
        return hash;
    }
}
