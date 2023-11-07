package stack;

import java.util.ArrayDeque;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        //fill the freq array
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(visited[ch -'a']) continue;

            while(!stack.isEmpty() && stack.peek() > ch && freq[stack.peek()-'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(ch);
            visited[ch -'a'] = true;
        }
        char[] ans = new char[stack.size()];
        int i = ans.length -1;
        while(!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return new String(ans);
    }
}
