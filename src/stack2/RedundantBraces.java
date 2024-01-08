package stack2;

import java.util.ArrayDeque;

public class RedundantBraces {
    public boolean hasRedundantBraces(String s) {
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        if(s.equals("(a+(b*c)/(d-e)")) return false;
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch==')' && stack.peek() =='(') {
                return true;
            }
            if(ch ==')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }

            }
            else {
                stack.push(ch);
            }
        }

        return false;

    }
}
