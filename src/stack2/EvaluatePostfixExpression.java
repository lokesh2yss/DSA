package stack2;

import java.util.ArrayDeque;

public class EvaluatePostfixExpression {
    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    public int evalPostfix(String[] A)
    {
        int n = A.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i< n; i++) {
            String s = A[i];
            if(isOperator(s)) {
                if(!stack.isEmpty()) {
                    int second = stack.pop();
                    if(!stack.isEmpty()) {
                        int first = stack.pop();
                        int result = evaluateExp(s, first, second);
                        stack.push(result);
                    }
                }
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        if(!stack.isEmpty())  {
            return stack.pop();
        }
        return -1;
    }
    public int evaluateExp(String operator, int first, int second) {
        switch(operator) {
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "+":
                return first + second;
            case "-":
                return first - second;
        }
        return -1;
    }

}
