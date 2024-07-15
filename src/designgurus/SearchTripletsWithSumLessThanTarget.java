package designgurus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTripletsWithSumLessThanTarget {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 2, 1, 3};
        int target = 5;
        System.out.println(searchTriplets(arr, target));
    }
    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        int count = 0;
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i< n-2; i++) {
            int left = i + 1;
            int right = n -1;
            while(left<right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if(currentSum >= target) {
                    right--;
                }
                else {
                    int l = right;
                    while(l>left) {
                        ans.add(Arrays.asList(arr[i], arr[left], arr[l]));
                        l--;
                    }
                    count += right -left;
                    left++;
                }
            }
        }
        return ans;
    }
}
