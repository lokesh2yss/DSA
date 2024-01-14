package queue;
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        boolean[] state = new boolean[256];
        Queue<Character> q = new LinkedList();
        int max = 0;
        char head;
        for (int i = 0; i < c.length; i++) {
            if (state[c[i]] == true) {
                if (q.size() > max) {
                    max = q.size();
                }
                do {
                    head = q.poll();
                    state[head] = false;
                } while (head != c[i]);
            }
            q.offer(c[i]);
            state[c[i]] = true;
        }
        if (q.size() > max) {
            max = q.size();
        }
        return max;


    }
}
