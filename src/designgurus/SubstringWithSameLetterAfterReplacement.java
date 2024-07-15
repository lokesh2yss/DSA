package designgurus;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithSameLetterAfterReplacement {
    public static void main(String[] args) {
        String str = "aabccbb";
        int k = 2;
        System.out.println(findLength(str, k));
    }
    public static int findLength(String str, int k) {
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxRepeatCharFreq = 0;
        int windowStart = 0;
        for(int windowEnd=0; windowEnd < str.length(); windowEnd++) {
            char eChar = str.charAt(windowEnd);
            freqMap.put(eChar, freqMap.getOrDefault(eChar, 0) + 1);
            maxRepeatCharFreq = Math.max(maxRepeatCharFreq, freqMap.get(eChar));
            int lettersToReplace = windowEnd - windowStart + 1 - maxRepeatCharFreq;

            while(lettersToReplace > k) {
                char sChar = str.charAt(windowStart);
                int freq = freqMap.get(sChar);
                freq--;
                if(freq == 0) freqMap.remove(sChar);
                else {
                    freqMap.put(sChar, freq);
                }
                windowStart++;
                lettersToReplace--;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
