package dynamicprogrammingadvanced;

public class SubSetProblem {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSumTopDown(arr, sum));
        System.out.println(isSubsetSumBottomUp(arr, sum));
    }
    public static Boolean isSubsetSumBottomUp(int[] arr, int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=sum;i++) dp[0][i] = false;
        for(int i=1;i<=n;i++) {
            for(int curSum=1; curSum <= sum; curSum++) {
                if(arr[i-1] > curSum) {
                    dp[i][curSum] = dp[i - 1][curSum];
                }
                else {
                    dp[i][curSum] = dp[i - 1][curSum] || dp[i - 1][curSum - arr[i-1]];

                }
            }
        }
        return dp[n][sum];
    }
    public static Boolean isSubsetSumTopDown(int arr[], int sum){
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return isSubsetSumHelper(arr, sum, n-1, dp);
    }
    public static boolean isSubsetSumHelper(int[] arr, int sum, int index,  Boolean[][] dp) {
        if(sum == 0) return true;
        if(index < 0) return false;

        if(dp[index][sum] != null) return dp[index][sum];
        if(arr[index] > sum) return dp[index][sum] = isSubsetSumHelper(arr, sum, index-1, dp);
        return dp[index][sum] = isSubsetSumHelper(arr, sum-arr[index], index-1, dp) ||
                isSubsetSumHelper(arr, sum, index-1, dp);
    }
}
