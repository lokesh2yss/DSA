package stack2;

import java.util.ArrayDeque;

public class InfixToPostfix {
    public static boolean isOperator(char ch) {
        return ch=='^' || ch == '*' || ch == '/' || ch == '+' || ch =='-';
    }
    public static int precedence(char ch) {
        switch(ch) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;//case for (
        }
    }
    public static String infixToPostfix(String infixExpression) {
        infixExpression = infixExpression.replace(" ","");
        int n = infixExpression.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            char ch = infixExpression.charAt(i);
            if(ch=='(') {
                stack.push(ch);
            }
            else if(isOperator(ch)) {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    char popped = stack.pop();
                    sb.append(popped);
                }
                stack.push(ch);
            }
            else if(ch ==')') {
                while(!stack.isEmpty() && stack.peek() !='(') {
                    char popped = stack.pop();
                    sb.append(popped);
                }
                stack.pop();
            }
            else {
                sb.append(ch);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
