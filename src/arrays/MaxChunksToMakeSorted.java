package arrays;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        //cyclic sort
        int n = arr.length;
        int chunkCount = 0;
        int currSum = 0;
        int expectedSum = 0;
        int i = 0;
        while(i<n) {
            currSum += arr[i];
            expectedSum += i;
            if(currSum==expectedSum) {
                chunkCount++;
            }
            i++;
        }
        return chunkCount;

    }
}
