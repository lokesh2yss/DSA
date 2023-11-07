package search;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = 344;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] search(int[][] arr, int target) {
        int[] ans = {-1,-1};
        int n = arr.length;
        int m = arr[0].length;
        int row = 0;
        int col = m-1;
        while(row < n && col >=0) {
            if(target==arr[row][col]) {
                ans[0] = row;
                ans[1] = col;
                return ans;
            }
            if(target > arr[row][col]) {
                row++;
            }
            else {
                col--;
            }

        }
        return ans;
    }
}
