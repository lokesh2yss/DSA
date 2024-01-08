package stack2;

import java.util.ArrayDeque;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(num.charAt(0));
        for(int i=1;i<n;i++) {
            char ch = num.charAt(i);
            while(!stack.isEmpty() && k>0 && ch < stack.peek()) {
                stack.pop();
                k--;
            }
            if(stack.size() ==1 && stack.peek() == '0') {
                stack.pop();
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k>0) {
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
