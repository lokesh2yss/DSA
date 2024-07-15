package designgurus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static void main(String[] args) {
        String str = "helloworld";
        String pattern = "world";
        System.out.println(findStringAnagrams(str,pattern));
    }
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0, matched = 0;
        for(char c: pattern.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(freqMap);
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);
            if(freqMap.containsKey(endChar)) {
                freqMap.put(endChar, freqMap.get(endChar) -1);
                if(freqMap.get(endChar) == 0) matched++;
            }
            if(matched==freqMap.size()) {
                resultIndices.add(windowStart);
            }
            if(windowEnd >= pattern.length() -1) {
                char startChar = str.charAt(windowStart);
                if(freqMap.containsKey(startChar)) {
                    if(freqMap.get(startChar) == 0) matched--;
                    freqMap.put(startChar, freqMap.get(startChar)+1);
                }
                windowStart++;
            }
        }
        return resultIndices;
    }
}
