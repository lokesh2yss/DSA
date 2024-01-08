package stack2;

import java.util.ArrayDeque;

public class BalancedParenthesis {
    public int isBalanced(String A) {
        int n = A.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i =0; i<n; i++) {
            char ch = A.charAt(i);
            if(ch=='(') {
                stack.push(ch);
            }
            else {
                if(!stack.isEmpty()) {
                    if(stack.peek() =='(') {
                        stack.pop();
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    return 0;
                }
            }
        }
        if(stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
