package designgurus;

public class MinimumWindowSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 10, 9, 12};
        System.out.println(sort(arr));
    }
    public static int sort(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        for(int i=0;i<n-1;i++) {
            if(arr[i] <= arr[i+1]) left++;
            else break;
        }
        for(int i=n-1;i>0;i--) {
            if(arr[i] >= arr[i-1]) right--;
            else break;
        }
        if(left == n-1 || right == 0) return 0; //array is already sorted;
        int windowMax = Integer.MIN_VALUE;
        int windowMin = Integer.MAX_VALUE;
        for(int i=left; i<=right;i++) {
            windowMax = Math.max(windowMax, arr[i]);
            windowMin = Math.min(windowMin, arr[i]);
        }
        for(int i=left-1; i>=0; i--) {
            if(arr[i] > windowMin) left--;
        }
        for(int i=right+1; i<n; i++) {
            if(arr[i] < windowMax) right++;
        }
        return right-left+1;
    }
}
