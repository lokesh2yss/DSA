package arrays;

import java.util.ArrayList;

public class MaxAbsolutedifference {
    public int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        int[] aipi = new int[n];
        int[] aimi = new int[n];
        for(int i = 0; i< n; i++) {
            aipi[i] = A.get(i) + i + 1;
            aimi[i] = A.get(i) - (i+1);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=0; i<n;i++) {
            max1 = Math.max(max1, aipi[i]);
            max2 = Math.max(max2, aimi[i]);
            min1 = Math.min(min1, aipi[i]);
            min2 = Math.min(min2, aimi[i]);
        }
        return Math.max(max1-min1,max2-min2);

    }
}
