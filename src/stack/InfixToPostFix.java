package stack;

import java.util.ArrayDeque;

public class InfixToPostFix {
    public static int precedence(char c) {
        switch(c) {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
                return -1;
        }
        return 0;
    }
    public static String infixToPostfix(String infixExpression) {
        infixExpression = infixExpression.replace(" ","");
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String result = "";
        for(int i=0; i< infixExpression.length();i++) {
            char cur = infixExpression.charAt(i);
            switch(cur) {
                case '(':
                    stack.push(cur);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() !='(') {
                        char popped = stack.pop();
                        result += popped;
                    }
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case '^':
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(cur)) {
                        char popped = stack.pop();
                        result += popped;
                    }
                    stack.push(cur);
                    break;
                case '*':
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(cur)) {
                        char popped = stack.pop();
                        result += popped;
                    }
                    stack.push(cur);
                    break;
                case '/':
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(cur)) {
                        char popped = stack.pop();
                        result += popped;
                    }
                    stack.push(cur);
                    break;
                case '+':
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(cur)) {
                        char popped = stack.pop();
                        result += popped;
                    }
                    stack.push(cur);
                    break;
                case '-':
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(cur)) {
                        char popped = stack.pop();
                        result += popped;
                    }
                    stack.push(cur);
                    break;
                default:
                    result += cur;
            }
        }
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;

    }
}
