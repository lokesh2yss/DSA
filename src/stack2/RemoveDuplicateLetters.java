package stack2;

import java.util.ArrayDeque;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        int[] freq = new int[26];
        for(int i=0; i<n;i++) {
            char ch = s.charAt(i);
            freq[ch -'a']++;
        }
        for(int i=0; i<n;i++) {
            char ch = s.charAt(i);
            freq[ch -'a']--;
            if(visited[ch -'a']) continue;
            while(!stack.isEmpty() && stack.peek() > ch && freq[stack.peek() -'a'] > 0) {
                visited[stack.peek() -'a'] = false;
                stack.pop();
            }
            stack.push(ch);
            visited[ch -'a'] = true;
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
