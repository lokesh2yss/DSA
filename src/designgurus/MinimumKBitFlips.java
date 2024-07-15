package designgurus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumKBitFlips {
    public static void main(String[] args) {
        //int[] arr = {1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
        int[] arr = {1,1,1,0,0,0,0,0,0,1,1,1};
        int k = 3;
        System.out.println(findMinFlips(arr, k));
    }
    public static int findMinFlips(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(((q.size()&1) == 0 && arr[i] == 0) || ((q.size()&1) != 0 && arr[i] == 1)) {
                //add a flip
                if(i+k-1 >= n) return -1;
                count++;
                q.offer(i+k-1);
            }
            if(!q.isEmpty() && q.peek() == i) {
                q.poll();
            }
        }
        return count;
    }
}
