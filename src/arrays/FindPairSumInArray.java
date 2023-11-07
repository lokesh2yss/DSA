package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindPairSumInArray {
    public List<List<Integer>> findPair(int[] arr)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0;i<n;i++) {
            hset.add(arr[i]);
        }
        boolean isFound = false;
        //Arrays.sort(arr);
        for(int i = 0; i< n; i++) {
            for(int j= i+1; j<n;j++) {
                if(hset.contains(arr[i] + arr[j])) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    ans.add(temp);
                    isFound = true;
                }
            }
        }
        if (isFound)
        {
            ans.sort((a, b) -> {
                int cmp = Integer.compare(a.get(0), b.get(0));
                if (cmp == 0) {
                    return Integer.compare(a.get(1), b.get(1));
                }
                return cmp;
            });
        }
        return ans;
    }

}
