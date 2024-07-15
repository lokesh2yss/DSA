package designgurus;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/../";
        System.out.println(simplifyPath(s));
    }
    public static String simplifyPath(String path) {
        int n = path.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            char c = path.charAt(i);
            System.out.println(c+ " " +stack);
            if(!stack.isEmpty() && stack.peek() == '/' && c == '/') {
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == '.' && c == '/') {
                stack.pop();
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == '.' && c == '.') {
                System.out.println("IMMMM");
                stack.pop();
                if(!stack.isEmpty()) {
                    stack.pop();
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                continue;
            }
            stack.push(c);
        }
        System.out.println(stack);
        if(!stack.isEmpty() && stack.peek() == '/' && stack.size() > 1) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        StringBuilder rev = sb.reverse();

        return rev.toString();
    }
}
