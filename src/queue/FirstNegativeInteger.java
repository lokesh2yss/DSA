package queue;

import java.util.ArrayDeque;

public class FirstNegativeInteger {
    public static void main(String[] args) {
        int[] arr = {2,-4,-6, 8, -13, 9, -3, 11, 15, 6};
        int[] ans = firstNegativeInteger(arr,3);
        for(int e: ans) {
            System.out.print(e+" ");
        }
    }
    public static int[] firstNegativeInteger(int[] arr, int k) {
        int n = arr.length;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int i =0;
        while(i<k) {
            if(arr[i] <0) {
                dq.offerLast(arr[i]);
            }
            i++;
        }
        for(;i<n;i++) {
            if(!dq.isEmpty()) {
                ans[i-k] = dq.getFirst();
            }
            else {
                ans[i-k] = 0;
            }
            if(!dq.isEmpty() && arr[i-k] == dq.getFirst()) {
                dq.pollFirst();
            }
            if(arr[i] < 0) {
                dq.offerLast(arr[i]);
            }
        }
        if(dq.isEmpty()) {
            ans[n-k] = 0;
        }
        else {
            ans[n - k] = dq.getFirst();
        }
        return ans;
    }
}
