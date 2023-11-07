package arrays;

public class InterestingArray {
    public static int isInteresting(int[] arr)
    {
        int n = arr.length;
       /*1. An even number can be reduced to zero by splitting it into two halfs arr[i]/2
            XOR between these two equal numbers results in zero
         2. An odd number can be split int to two parts: arr[i] -1, and 1. Since Arr[i]-1 is even, it can be reduced to zero.
            The remaining 1 must be XORed with another 1 coming from another odd number. Therefore, if the number of odd numbers
            in the array is even, it can be reduced to zero or else not;
         */
        int oddNumberCount = 0;
        for(int i = 0; i<n;i++) {
            if(arr[i]%2 ==1) {
                oddNumberCount++;
            }
        }
        if(oddNumberCount%2 == 0) {
            return 1;
        }
        return 0;


    }
}
