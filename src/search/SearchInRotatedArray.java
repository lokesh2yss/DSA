package search;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int k = findRorationIndexK(nums);
        System.out.println(k);
    }
    public static int findRorationIndexK(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while(start<=end) {
            int mid = start + (end- start)/2;
            if(mid+1 < nums.length && nums[mid]> nums[mid+1]) {
                return mid;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
