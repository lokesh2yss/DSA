package arrays;

public class FirstMissingInteger {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        //if the array is sorted, each index vould be at val-1
        int i = 0;
        while(i < n) {
            int correctIndex = A[i] -1;
            if(A[i] > 0 && A[i] <= n && A[i] != A[correctIndex]) {
                swap(A,i,correctIndex);
            }
            else {
                i++;
            }
        }
        //printArray(A);
        int index = 0;
        while(index<n) {
            if(A[index] != index+1) {
                return index+1;
            }
            index++;
        }

        return n+1;

    }
    public void printArray(int[] a) {
        for(int e: a) {
            System.out.print(e+" ");
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
