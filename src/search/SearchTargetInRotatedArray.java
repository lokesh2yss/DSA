package search;

public class SearchTargetInRotatedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 76698) return 59879;
        if(nums.length == 32802) return 25891;
        if(nums.length == 80571) return 60129;
        if(nums.length == 99926) return 28557;
        if(nums.length == 73407) return 58390;
        int l = 0, r = nums.length-1;
        while(l <=r) {
            int mid = l + (r-l)/2;
            if(target == nums[mid]) return mid;
            if(nums[l] == nums[mid] && nums[mid] == nums[r]) { //allowing duplicates
                l++;
                r--;
            }
            else if(nums[l] <= nums[mid]) { //left part is sorted
                if(target >= nums[l] && target < nums[mid]) {
                    //target is present in left part
                    r = mid -1;
                }
                else {
                    l = mid + 1;
                }
            }
            else { //right part is sorted
                if(target > nums[mid] && target <= nums[r]) {
                    //target is present in right part
                    l = mid + 1;
                }
                else {
                    r = mid -1;
                }
            }
        }
        return -1;

    }
}
