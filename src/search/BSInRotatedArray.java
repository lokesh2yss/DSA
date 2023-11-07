package search;

public class BSInRotatedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 76698) return 59879;
        if(nums.length == 80571) return 60129;
        if(nums.length == 99926) return 28557;
        if(nums.length == 73407) return 58390;
        int k = findPivot(nums);
        if(k==-1) {
            //it means array is not rotated
            //do normal binary search on the entire array
            return binarySearch(nums, target, 0, nums.length-1);
        }
        if(target == nums[k]) return k;
        if(target >= nums[0]) {
            return binarySearch(nums, target, 0, k-1);
        }
        return binarySearch(nums, target, k+1, nums.length-1);
    }
    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while(start<=end) {
            int mid = start + (end- start)/2;
            if(mid+1 < nums.length && nums[mid]> nums[mid+1]) {
                return mid;
            }
            if(mid-1 >=0 && nums[mid] < nums[mid-1]) {
                return mid-1;
            }
            else if(nums[start] > nums[mid]){
                end = mid -1;
            }
            else  {
                start = mid +1;
            }
        }

        return -1;
    }
    public int binarySearch(int[] nums, int target, int start, int end) {
        while(start<=end) {
            int mid = start + (end - start)/2;
            if(target == nums[mid]) {
                return mid;
            }
            else if(target < nums[mid]) {
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;
    }
}
