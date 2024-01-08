package search;

public class CountOccurences {
    public int count(int[] arr, int n, int x) {
        int l = 0;
        int r = n-1;
        int occurences = 0;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(x == arr[mid]) {
                int i = mid;
                while(i >=0 && arr[i] == x) {
                    occurences++;
                    i--;
                }
                i = mid+1;
                while(i<n && arr[i] == x) {
                    occurences++;
                    i++;
                }
                return occurences;
            }
            else if(x > arr[mid]) {
                l = mid+1;
            }
            else {
                r = mid -1;
            }
        }
        return occurences;




    }
}
