package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i< nums.length-2;i++) {
            if(i> 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int curr = nums[i];
            List<List<Integer>> temp = twoSum(nums, -curr, i+1);
            for(List<Integer> list : temp) {
                list.add(0, curr);
                ans.add(list);
            }
        }

        return ans;


    }
    public List<List<Integer>> twoSum(int[] nums, int target, int startFrom) {
        int l = startFrom;
        int r = nums.length -1;
        List<List<Integer>> ans = new ArrayList<>();
        while(l < r) {
            if(l > startFrom && nums[l] == nums[l-1]) {
                l++;
                continue;
            }
            if(r<nums.length-1 && nums[r] == nums[r+1]) {
                r--;
                continue;
            }
            if(nums[l] + nums[r] < target) {
                l++;
            }
            else if(nums[l] + nums[r] > target) {
                r--;
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                ans.add(temp);
                l++;
                r--;
            }
        }
        return ans;
    }
}
