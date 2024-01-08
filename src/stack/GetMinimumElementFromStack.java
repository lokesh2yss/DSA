package stack;

import java.util.Stack;

public class GetMinimumElementFromStack {
    class MyStack {
        int minEle;
        Stack<Integer> s;

        MyStack() {
            minEle = Integer.MAX_VALUE;
            s = new Stack<>();
        }

        int getMin() {
            if(minEle == Integer.MAX_VALUE) {
                return -1;
            }
            return minEle;
        }

        int pop() {
            if(s.isEmpty()) {
                minEle = Integer.MAX_VALUE;
                return -1;
            }
            int tmp = 0;
            int v = s.peek();
            if(v >= minEle) {
                tmp = s.pop();
            }
            else {
                int y = 2*minEle - v;
                minEle = y;
                s.pop();
                tmp = (v + y)/2;

            }
            if(s.isEmpty()) {
                minEle = Integer.MAX_VALUE;
            }
            return tmp;
        }

        void push(int x) {
            if(s.isEmpty()) {
                s.push(x);
                minEle = x;
            }
            else {
                int a = x;
                if(x<minEle) {
                    a = 2*x -minEle;
                    minEle = x;
                }
                s.push(a);
            }

        }
    }

}
