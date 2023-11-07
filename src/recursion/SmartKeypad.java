package recursion;

import java.util.ArrayList;
import java.util.List;

public class SmartKeypad {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<String>();
        String combination = "";
        int index = 0;
        solve(index, digits,combination, mapping, ans);
        return ans;
    }

    public void solve(int index, String digits, String combination, String[] mapping, List<String> ans) {
        //base case
        if(index == digits.length()) {
            ans.add(combination);
            return;
        }
        int number = digits.charAt(index) - '0';
        String value = mapping[number];
        for(int i=0; i < value.length();i++ ) {
            combination += value.charAt(i);
            solve(index+1, digits,combination, mapping, ans);
            combination = combination.substring(0, combination.length()-1);
        }
    }
}
