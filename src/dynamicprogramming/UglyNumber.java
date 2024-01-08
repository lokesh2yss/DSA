package dynamicprogramming;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class UglyNumber {
    public static void main(String[] args) {
        int n = 1685;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        //for(int i=1;i<n;i++) {
            System.out.println(nthUglyNumberBottomUp(n));
            //System.out.println(i+1+"-> "+ nthUglyNumberHelper(i - 1, dp)+ " ");
            //System.out.print(nthUglyNumberBottomUp(i-1)+ " ");
        //}
        //System.out.println(nthUglyNumberHelper(27,dp));
        System.out.println();
    }
    public static int nthUglyNumber(int n) {
        int[] nums = new int[1680];
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) ++i2;
            if (ugly == nums[i3] * 3) ++i3;
            if (ugly == nums[i5] * 5) ++i5;
        }
        return nums[n-1];
    }
    public static int nthUglyNumberHelper(int n, int[] dp) {
        if(n==0) return 1;
        if(dp[n] != -1) return dp[n];
        int[] factors = {1, 2, 3, 4 ,5, 6, 7, 8, 9, 10};
        int nmin1thUgluNum = nthUglyNumberHelper(n-1, dp);
        for(int i=0;i<factors.length;i++) {
            int num = factors[i] + nmin1thUgluNum;
            if(isUglyNumber(num)) return dp[n] =  num;
        }
        return -1;
    }
    public static int nthUglyNumberSet(int n) {
        Set<Integer> set = new TreeSet();
        set.add(1);
        int i = 2;
        int ans = 0;
        while(set.size() < n) {
            if(i%2==0 && set.contains(i/2)) {
                set.add(i);
                ans = i;
            } else if(i%3==0 && set.contains(i/3)) {
                set.add(i);
                ans = i;
            } else if(i%5==0 && set.contains(i/5)) {
                set.add(i);
                ans = i;
            }
            i++;
        }
        return ans;
    }
    public static boolean isUglyNumber(int num) {
        while(num !=1) {
            while(num%2 == 0) {
                num = num / 2;
            }
            while(num%3 == 0) {
                num = num/3;
            }
            while(num%5 == 0) {
                num = num/5;
            }
            if(num != 1) return false;
        }
        return true;
    }
    public static int nthUglyNumberBottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int N = 1000;
        int[] factors = new int[N];
        for(int i=0;i<N; i++) {
            factors[i] = i+1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<N;j++) {
                int num = dp[i - 1] + factors[j];
                if (isUglyNumber(num)) {
                    dp[i] = num;
                    break;
                }
            }
        }
        return dp[n];
    }
}
