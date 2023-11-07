package search;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {416938462, 581621107, 602286890, 719115542, 304478554, 950352556, 609684359, 140839799, 267061351, 265097393};
        //int[] stalls = {10,1,2,7,5};
        int n = 10;
        int k = 5;
        System.out.println(solve(n,k,stalls));
    }
    public static int solve(int n, int k, int[] stalls) {
        int l = 0;
        int h = (int) 1e9;
        Arrays.sort(stalls);
        int ans = -1;
        while(l <=h) {
            int m = l + (h-l)/2;
            System.out.println("l="+l+" m="+m+" h="+h );
            if(isPossible(stalls, k, m)) {
                ans = m;
                l = m +1;
            }
            else {
                h = m-1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] stalls, int k, int distance) {
        int count = 1;
        int prev = stalls[0];
        for(int i = 1; i<stalls.length;i++) {
            if(stalls[i] - prev >= distance) {
                count++;
                prev= stalls[i];
            }
        }
        return count >=k;
    }
}
