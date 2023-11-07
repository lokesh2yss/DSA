package search;

import java.util.Arrays;

public class BinarySearchInSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 122;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] search(int[][] matrix, int target) {
        int[] ans = {-1, -1};
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows==1) {
            return BinarySearch(matrix,0,0, cols -1, target);
        }
        int rStart = 0;
        int rEnd = rows-1;
        int cMid = cols/2;
        while(rStart< rEnd-1) {
            int mid = rStart + (rEnd - rStart)/2;
            if(target == matrix[mid][cMid]) {
                return new int[] {mid, cMid};
            }
            if(target < matrix[mid][cMid]) {
                rEnd = mid;
            }
            else {
                rStart = mid;
            }
        }
        //now we have two rows left
        //check in the middle col in the two rows
        if(matrix[rStart][cMid] == target) {
            return new int[] {rStart, cMid};
        }
        if(matrix[rStart+1][cMid] == target) {
            return new int[] {rStart+1, cMid};
        }

        //search in 1st half
        if(target <= matrix[rStart][cMid-1]) {
            return BinarySearch(matrix, rStart, 0, cMid - 1, target);
        }
        //search in 2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]) {
            return BinarySearch(matrix, rStart, cMid + 1, cols-1, target);
        }

        //search in 3rd half
        if(target <= matrix[rStart+1][cMid-1]) {
            return BinarySearch(matrix, rStart+1, 0, cMid - 1, target);
        }
        //search in 4th half
        else {
            return BinarySearch(matrix, rStart+1, cMid + 1, cols-1, target);
        }
    }
    public static int[] BinarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while(cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart)/2;
            if(target == matrix[row][mid]) {
                return new int[] {row, mid};
            }
            if(target > matrix[row][mid]) {
                cStart = mid + 1;
            }
            else {
                cEnd = mid -1;
            }
        }
        return new int[] {-1,-1};
    }
}
