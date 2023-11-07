package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "abbaca";
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        palindromePartitioning(s,0,ans, new ArrayList<String>());
        for(ArrayList<String> str : ans) {
            System.out.println((str));
        }
    }
    public static void palindromePartitioning(String s, int index, ArrayList<ArrayList<String>> ans, ArrayList<String> cur) {
        if(index==s.length()) {
            ans.add(new ArrayList<String>(cur));
            return;
        }
        for(int i=index; i<s.length();i++) {
            if(isPalindrome(s, index, i)) {
                cur.add(s.substring(index, i+1));
                palindromePartitioning(s,i+1,ans, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
