package arrays;

public class MakeMatrixEqual {
    public static int minOperations(int n, int m, int k, int A[][]) {
        //convert matrix into an array
        int total = n*m;
        int[] arr = new int[total];
        for(int i=0;i<n;i++) {
            for(int j=0; j<m;j++) {
                arr[i*m + j] = A[i][j];
            }
        }
        int median = arr[total/2];

        return makeMatrixEqual(arr,median,k);


    }
    public static int makeMatrixEqual(int[] a, int m, int k) {
        int count = 0;
        for(int i=0; i<a.length;i++) {
            boolean isInteger = (a[i]-m)%k ==0? true:false;
            if(!isInteger) return -1;
            count += Math.abs((a[i]-m)/k);
        }
        return count;
    }
}
