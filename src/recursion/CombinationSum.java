package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum2Helper(0, candidates, target, ans, path);
        return ans;
    }
    public void combinationSum2Helper(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> path) {
        if(target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i< candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            int newTarget = target - candidates[i];
            if(newTarget < 0 ) break;
            path.add(candidates[i]);
            combinationSum2Helper(i+1, candidates, newTarget, ans, path);
            path.remove(path.size()-1);
        }

    }

}
