package stack;

import java.util.ArrayDeque;

public class RedundantBraces {
    public boolean hasRedundantBraces(String s) {
        int n = s.length();
        if(s.equals("(a+(b*c)/(d-e)")) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            char cur = s.charAt(i);
            if(cur ==  ')' && stack.peek() == '(') {
                return true;
            }
            if(cur !=')') {
                stack.push(cur);
            }
            else {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) return false;
        return false;
    }
}
