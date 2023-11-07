package arrays;

public class DifferencePossible {
    public boolean diffPossible(int[] arr, int k)
    {
        int n = arr.length;
        for(int i = 0; i< n; i++) {
            for(int j = i+1; j<n; j++) {
                int diff = arr[i] - arr[j];
                if(Math.abs(diff) ==k) {
                    return true;
                }
            }
        }

        return false;


    }
}
