package search;

public class Floor {
    public static void main(String[] args) {
        int[] nums = {-6, 8, 13, 45, 56, 88};
        int target = -8;
        System.out.println(findFloor(nums, target));
    }
    public static int findFloor(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start<=end) {
            int mid = start + ( end - start) /2;
            if(target == nums[mid]) return mid;
            if(target > nums[mid]) {
                //look right
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return end;
    }
}
