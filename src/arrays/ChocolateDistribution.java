package arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    public int findMinDiff(int[] arr, int m)
    {
        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<= n-m;i++) {
            minDiff = Math.min(minDiff, arr[i + m-1] - arr[i]);
        }
        return minDiff;
    }
}
