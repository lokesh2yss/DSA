package bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedPermutationRank {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(findRank(s));
    }
    public static int findRank(String A) {
        int n = A.length();
        long[] fact = new long[26];
        fact[0] = 1;
        fact[1] = 1;
        int[] asciiArr = new int[256];
        for(int i=2;i<26;i++) {
            fact[i] = (i*fact[i-1])%100003;
        }
        for(int i=0; i<n;i++) {
            asciiArr[A.charAt(i)]++;
        }
        long ans = 0;
        int numOfSmallerCharacters = 0;
        for(int i=0;i<n;i++) {
            numOfSmallerCharacters = 0;
            for(int j=0;j<256;j++) {
                if(A.charAt(i) == j) {
                    break;
                }
                if(asciiArr[j] == 1) {
                    numOfSmallerCharacters++;
                }
            }
            asciiArr[A.charAt(i)]= 0;
            ans = (ans%100003 + (numOfSmallerCharacters%100003)*((fact[n-i-1])%100003))%100003;
        }
        return (int) ((ans+1)%100003);
    }

}
