package stack;

import java.util.ArrayDeque;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s)
    {
        ArrayDeque<Integer> iStack = new ArrayDeque<>();
        ArrayDeque<Character> cStack = new ArrayDeque<>();
        int max = 0;
        iStack.push(-1);
        for(int i=0; i<s.length();i++) {
            if(s.charAt(i) =='(') {
                cStack.push('(');
                iStack.push(i);
            }
            else {
                //closing bracket
                if(!cStack.isEmpty() && cStack.peek() == '(') {
                    cStack.pop();
                    iStack.pop();
                    max = Math.max(max, i-iStack.peek());
                }
                else {
                    //problem char
                    iStack.push(i);
                }
            }
        }
        return max;

    }
}
