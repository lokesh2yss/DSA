package stack2;

import java.util.ArrayDeque;

public class ReverseStringUsingStack {
    public char[] reverseString(char[] s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = s.length;
        for(int i=0;i<n;i++) {
            stack.push(s[i]);
        }
        char[] reversed = new char[n];
        for(int i=0;i<n;i++) {
            reversed[i] = stack.pop();
        }
        return reversed;
    }
}
