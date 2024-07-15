package designgurus;
class Solution {
    // TODO: Write your code here
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        System.out.println(new String(chars));
        System.out.println(isVowel('i'));
        while(left < right) {
            if(isVowel(chars[left]) && isVowel(chars[right])) {
                swap(chars, left, right);
                left++;
                right--;
            }
            else if(isVowel(chars[left])) {
                right--;
            }
            else if(isVowel(chars[right])) {
                left++;
            }
            else {
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public boolean isVowel(char ch) {
        return ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch=='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
public class ReverseVowels {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AEIOU";
        System.out.println("AAAAAA");
        System.out.println(solution.reverseVowels(s));
    }
}
