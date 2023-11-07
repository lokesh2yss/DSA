package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class PermutationsOfAString {
    public List<String> permute(String str) {

        List<String> ans = new ArrayList<String>();
        boolean[] map = new boolean[str.length()];
        permuteHelper(str, ans, map, "");
        LinkedHashSet<String> hset = new LinkedHashSet<>();
        hset.addAll(ans);
        List<String> uAns = new ArrayList<String>();
        for(String s: hset) {
            uAns.add(s);
        }
        Collections.sort(uAns);
        return uAns;
    }
    public void permuteHelper(String str, List<String> ans, boolean[] map, String permutation) {
        if(permutation.length() == str.length()) {
            ans.add(permutation);
            return;
        }
        for(int i=0 ; i< str.length(); i++) {
            if(!map[i]) {
                map[i] = true;
                permutation += str.charAt(i);
                permuteHelper(str, ans, map, permutation);
                map[i] = false;
                permutation = permutation.substring(0, permutation.length()-1);
            }
        }
    }

}
