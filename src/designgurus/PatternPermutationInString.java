package designgurus;

import java.util.HashMap;
import java.util.Map;

public class PatternPermutationInString {
    public static void main(String[] args) {
        String str = "oidbcaf";
        String pattern = "abc";
        System.out.println(findPermutation(str, pattern));
    }
    public static boolean findPermutation(String str, String pattern) {
        //use a sliding window approach
        //check if in current window of length pattern.length(), all
        //characters of pattern are present or not
        System.out.println(str+"   "+pattern);
        int n = str.length();
        int m = pattern.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i<m;i++) {
            freqMap.put(pattern.charAt(i), freqMap.getOrDefault(pattern.charAt(i),0)+1);
        }
        System.out.println(freqMap.toString());
        int windowStart = 0;
        Map<Character, Integer> windowFreqMap = new HashMap<>();
        for(int windowEnd=0; windowEnd < n; windowEnd++) {
            char endChar = str.charAt(windowEnd);
            int freq = freqMap.getOrDefault(endChar, 0);
            if(freq == 0) {
                windowStart = windowEnd +1;
                windowFreqMap.clear();
                continue;
            }
            else {
                windowFreqMap.put(endChar, windowFreqMap.getOrDefault(endChar, 0) +1);
            }
            System.out.println(windowFreqMap);
            System.out.println(windowStart+" "+windowEnd);
            if(windowEnd - windowStart + 1 == m) {

                if(areMapsEqual(freqMap, windowFreqMap)) return true;
                else {
                    char startChar = str.charAt(windowStart);
                    freq = windowFreqMap.get(startChar);
                    freq--;
                    if(freq ==0) windowFreqMap.remove(startChar);
                    else windowFreqMap.put(startChar, freq);
                    windowStart++;
                }
            }
        }
        return false;
    }
    public static boolean areMapsEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if(map1.size() != map2.size()) return false;
        for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
            if(map2.get(entry.getKey()) != entry.getValue()) return false;
        }
        return true;
    }
}
