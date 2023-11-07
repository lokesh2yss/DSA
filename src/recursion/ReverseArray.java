package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        for(int i=0; i<nums.length/2;i++) {
            swap(nums, i, nums.length-i-1);
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
