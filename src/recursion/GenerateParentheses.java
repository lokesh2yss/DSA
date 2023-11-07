package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> AllParenthesis(int n) {
        List<String> ans  = new ArrayList<String>();
        AllParenthesisHelper(ans, n, "", 0, 0, 0);
        return ans;
    }
    public void AllParenthesisHelper(List<String> ans, int n, String parantheses, int open, int close, int index) {
        if(index == 2*n) {
            ans.add(parantheses);
            return;
        }
        if(open <n) {
            parantheses +="(";
            AllParenthesisHelper(ans, n, parantheses, open+1, close, index+1);
            parantheses = parantheses.substring(0,parantheses.length()-1);
        }
        if(close < open) {
            parantheses +=")";
            AllParenthesisHelper(ans, n, parantheses, open, close+1, index+1);
            parantheses = parantheses.substring(0,parantheses.length()-1);
        }
    }
}
