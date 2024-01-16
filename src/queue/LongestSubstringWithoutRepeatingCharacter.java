package queue;
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        boolean[] state = new boolean[256];
        Queue<Character> q = new LinkedList<>();
        int maxLength = 1;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            q.offer(c);
            if(state[c] == false) {
                state[c] = true;
            }
            else {
                maxLength = Math.max(maxLength, q.size()-1);
                while(!q.isEmpty() && q.peek() != c) {
                    state[q.peek()] = false;
                    q.poll();
                }
                q.poll();
            }
        }
        if(q.size() > maxLength) {
            maxLength = q.size();
        }
        return maxLength;
    }
}
