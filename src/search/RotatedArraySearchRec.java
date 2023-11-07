package search;

public class RotatedArraySearchRec {
    public static void main(String[] args) {
        int[] nums = {5,6,7,8,1,2,3};
        int  target = 4;
        int index = search(nums, target, 0, nums.length-1);
        System.out.println(index);
    }
    public static int search(int[] nums, int target, int start, int end) {
        if(start > end) return -1;
        int mid = start +  ( end - start )/2;
        if(target == nums[mid]) {
            return mid;
        }
        if(nums[start] <= nums[mid]) {
            if(target >= nums[start] && target < nums[mid]) {
                return search(nums, target, start, mid-1);
            }
            else {
                return search(nums, target, mid+1, end);
            }
        }
        else if(target > nums[mid] && target <= nums[end]) {
            return search(nums, target, mid+1, end);
        }
        else {
            return search(nums, target, start, mid-1);
        }
    }
}
