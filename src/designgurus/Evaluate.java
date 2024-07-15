package designgurus;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        String s = "231*+9-";
        System.out.println(evaluatePostFix(s));
    }
    public static int evaluatePostFix(String S)
    {
        int n = S.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            char c = S.charAt(i);
            if(isOperator(c)) {
                System.out.println(("IS  "+sb.toString()));
                stack.push(Integer.valueOf(sb.toString()));
                sb.setLength(0);
                if(!stack.isEmpty()) {
                    int b = stack.pop();
                    if(!stack.isEmpty()) {
                        int a = stack.pop();
                        int result = evaluate(c, a, b);
                        stack.push(result);

                    }
                }
            }
            else {
                sb.append(c);
            }
        }
        return stack.pop();
    }
    public static int evaluate(char c, int a, int b) {
        int result = 0;
        switch(c) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;
    }
    public static boolean isOperator(char c) {
        return c=='/' || c == '*' || c == '+' || c == '-' || c == '^';
    }
}
