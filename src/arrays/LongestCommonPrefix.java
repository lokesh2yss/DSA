package arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        //find shortest string
        String shortest= "";
        int minSize = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<strs.length; i++) {
            if(minSize > strs[i].length()) {
                minSize = strs[i].length();
                minIndex = i;
            }
        }
        shortest = strs[minIndex];
        for(int i = 0; i < minSize; i++) {
            for(int j=0; j< strs.length; j++) {
                if(shortest.charAt(i) != strs[j].charAt(i)) {
                    return longestCommonPrefix;
                }

            }
            longestCommonPrefix += shortest.charAt(i);
        }
        return longestCommonPrefix;
    }
}
