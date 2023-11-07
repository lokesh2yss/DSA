package stack;

import java.util.ArrayDeque;

public class EvaluatePostfix {
    public int evalPostfix(String[] A)
    {
        int n = A.length;
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i=0;i< n; i++) {
            if(A[i].equals("+") || A[i].equals("-") || A[i].equals("*") || A[i].equals("/")) {
                if(!stack.isEmpty()) {
                    int a = Integer.parseInt(stack.pop());
                    if(!stack.isEmpty()) {
                        int b = Integer.parseInt(stack.pop());
                        int c = evalExp(b, a, A[i]);
                        stack.push(c+"");
                    }
                }
            }
            else {
                stack.push(A[i]);
            }
        }
        return Integer.parseInt(stack.pop());

    }
    public int evalExp(int a, int b, String operator) {
        int result = 0;
        if(operator.equals("+")) {
            return a+b;
        }
        else if(operator.equals("-")) {
            return a-b;
        }
        else if(operator.equals("*")) {
            return a*b;
        }
        else if(operator.equals("/")) {
            return a/b;
        }
        return -1;
    }
}
