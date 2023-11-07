package arrays;

import java.util.Arrays;

public class MaxConsecutiveGap {
    public int maximumGap(int[] arr) {
        if(arr.length<2) return 0;
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] minBucket = new int[n-1];
        int[] maxBucket = new int[n-1];
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,Integer.MIN_VALUE);
        for(int i=0;i<n;i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        int interval = (int)Math.ceil((max-min+0.0)/(n-1));

        for(int i=0;i<n;i++) {
            if(arr[i] ==min || arr[i] ==max) continue;
            int index = (arr[i]-min)/interval;
            minBucket[index] = Math.min(minBucket[index], arr[i]);
            maxBucket[index] = Math.max(maxBucket[index], arr[i]);
        }
        int prev = min;
        int maxGap = Integer.MIN_VALUE;
        for(int i =0; i< minBucket.length;i++) {
            if(minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i]-prev);
            prev = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max-prev);
        return maxGap;
    }
}
