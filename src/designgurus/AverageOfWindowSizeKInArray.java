package designgurus;

import java.util.Arrays;

public class AverageOfWindowSizeKInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        System.out.println(Arrays.toString(findWindowAverage(arr, K)));
    }
    public static double[] findWindowAverage(int[] arr, int K) {
        double[] ans = new double[arr.length-K+1];
        double sum = 0;
        int left = 0;
        for(int right=0;right<arr.length;right++) {
            sum += arr[right];
            if(right >= K-1) {
                ans[left] = sum/K;
                sum -= arr[left];
                left++;
            }
        }
        return ans;
    }
}
