package stack;

import java.util.ArrayDeque;

public class ReverseStringUsingStack {
    public char[] reverseString(char[] s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i< s.length;i++) {
            stack.push(s[i]);
        }
        char[] reversed = new char[s.length];
        for(int i=0;i<s.length;i++) {
            reversed[i] = stack.pop();
        }
        return reversed;
    }
}
