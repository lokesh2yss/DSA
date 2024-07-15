package search;

public class CeilInASortedArray {
    public static int findCeil(long arr[], int n, long x)
    {
        int l = 0;
        int r = n-1;
        int ans = -1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(arr[m] == x) return m;
            if(arr[m] > x) {
                ans = m;
                r = m -1;
            }
            else {
                l = m +1;
            }
        }
        return ans;
    }
}
