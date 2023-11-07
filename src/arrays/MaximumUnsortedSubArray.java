package arrays;

import java.util.ArrayList;

public class MaximumUnsortedSubArray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        //use two pointers s and e
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int s, e, i = 0;
        for (s = 0; s < n - 1; s++) {
            if (A.get(s) >= A.get(s + 1)) {
                break;
            }
        }
        if (s == n - 1) {
            //array is already sorted
            ans.add(-1);
            //ans.add(-1);
            return ans;
        }
        for (e = n - 1; e > 0; e--) {
            if (A.get(e) < A.get(e - 1)) {
                break;
            }
        }
        //find min and max in the array from s to e
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (i = s; i <= e; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        for (i = 0; i < s; i++) {
            if (A.get(i) > min) {
                s = i;
                break;
            }
        }
        for (i = n - 1; i > e; i--) {
            if (A.get(i) < max) {
                e = i;
                break;
            }
        }
        ans.add(s);
        ans.add(e);
        return ans;
    }

}
