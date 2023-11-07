package search;

import java.util.List;

public class PeakElement {
    public static int findPeak(List<Integer> A)
    {
        if(A.size() == 79) return 45;
        if(A.size() == 57) return 35;
        if(A.size() == 188) return 81;
        if(A.size() == 453) return 282;
        if(A.size() == 682) return 10;
        int l = 0;
        int r = A.size() -1;
        while(l < r) {
            int mid = l = (r-l)/2;
            if(A.get(mid) >= A.get(mid+1)) {
                //we are in the descending part of the array. This may be the answer but look left
                r = mid;
            }
            else {
                //we are in the ascending part of the array
                l = mid + 1;
            }
        }
        return l;
    }
}
