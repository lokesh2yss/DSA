package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsequencesOfArray {

    public static ArrayList<ArrayList<Integer>> AllSubsets(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        Collections.sort(nums);
        AllSubsetsHelper(nums, 0,curr, ans);
        return ans;
    }
    public static void AllSubsetsHelper(ArrayList<Integer> nums, int start, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for(int i = start; i < nums.size();i++) {
            if(i>start && nums.get(i) == nums.get(i-1)) {
                continue;
            }
            curr.add(nums.get(i));
            AllSubsetsHelper(nums,i+1,curr, ans);
            curr.remove(curr.size()-1);
        }

    }
}
