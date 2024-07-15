package designgurus;

import java.util.Stack;

public class loopThroughStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        for(String s: stack) {
            System.out.println(s);
        }
    }
}
