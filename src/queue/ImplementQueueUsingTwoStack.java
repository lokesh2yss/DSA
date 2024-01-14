package queue;
import java.util.*;
public class ImplementQueueUsingTwoStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void Push(int x) {
        s1.push(x);
    }

    int Pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.peek());
            s1.pop();
        }

        int ans = -1;
        if (!s2.isEmpty()) {
            ans = s2.peek();
            s2.pop();
        }
        while (!s2.isEmpty()) {
            s1.push(s2.peek());
            s2.pop();
        }
        return ans;
    }
}
