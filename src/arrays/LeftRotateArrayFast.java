package arrays;

public class LeftRotateArrayFast {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] times = {2,3};
        int[][] ans = rotateArray(nums,times);
        for(int[] a: ans) {
            printArray(a);
            System.out.println();
        }

    }
    public static int[][] rotateArray(int[] nums, int[] times) {
        int[][] ans = new int[times.length][nums.length];
        int[] nums2 = new int[2*nums.length];
        for(int i=0; i < nums.length*2; i++) {
            nums2[i] = nums[i%nums.length];
        }
        //printArray(nums2);
        int count = 0;
        for(int time: times) {
            for(int i = time; i< time + nums.length; i++) {
                ans[count][i-time] = nums2[i];
            }
            count++;
        }
        return ans;
    }
    public static void printArray(int[] nums) {
        for(int i: nums) {
            System.out.print(i+" ");
        }
    }
}
