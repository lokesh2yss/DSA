package arrays;

public class TrappedRainWater {
    public long trap(int[] h) {
        //identify and measure the dip
        int n = h.length;
        long maxWater = 0;

        int[] leftArray = new int[n];
        int[] rightArray = new int[n];
        leftArray[0] = h[0];
        for(int i = 1; i< n; i++) {
            leftArray[i] = Math.max(h[i], leftArray[i-1]);
        }
        rightArray[n-1] = h[n-1];
        for(int i = n-2; i >=0; i--) {
            rightArray[i] = Math.max(h[i], rightArray[i+1]);
        }
        for(int i=0; i<n; i++) {

            maxWater += Math.min(leftArray[i],rightArray[i]) - h[i];
        }
        return maxWater;


    }
}
