package arrays;

import java.util.Arrays;

public class MinimizeMaxDiffBWHeights {
    public static int getMinDiff(int[] A, int n, int k) {
        if(n==1) return 0;
        Arrays.sort(A);
        int largest = A[n-1] - k;
        int smallest = A[0] + k;
        int min, max;
        int diff = A[n-1]  - A[0];
        for(int i = 1; i < n; i++) {
            //if(A[i] - k < 0 ) continue;
            max = Math.max(largest, A[i-1] + k);
            min = Math.min(smallest, A[i] - k);
            if(min <0) continue;
            diff = Math.min(diff, max - min);
        }
        return diff;

    }
}
