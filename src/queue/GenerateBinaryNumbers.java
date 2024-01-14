package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static ArrayList<String> generate(int N)
    {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        while(N-- > 0) {
            String temp = q.poll();
            ans.add(temp);
            q.offer(temp+"0");
            q.offer(temp+"1");
        }
        return ans;
    }
}
