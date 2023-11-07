package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDifferencePairs {
    public List<List< Integer>> minimumAbsDifference(int[] arr)
    {
        Arrays.sort(arr);
        int n = arr.length;
        int minDifference = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i-1] ;
            if(diff < minDifference) {
                minDifference = diff;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<n; i++) {
            if(arr[i] - arr[i-1] == minDifference ) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                ans.add(pair);
            }
        }

        return ans;
    }
}
