package queue;
import java.util.*;
public class FindFirstNonRepeatingCharacter {
    public static String FirstNonRepeating(String A)
    {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        int n = A.length();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            char c = A.charAt(i);
            q.offer(c);
            freq[c-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] >1) {
                q.poll();
            }
            if(q.isEmpty()) {
                sb.append("#");
            }
            else {
                sb.append(q.peek());
            }
        }
        return sb.toString();

    }
}
