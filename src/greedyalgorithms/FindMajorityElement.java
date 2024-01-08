package greedyalgorithms;

import java.util.HashMap;

public class FindMajorityElement {
    public static int majorityElement(int a[], int size)
    {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0;i<size;i++) {
            if(!freqMap.containsKey(a[i])) {
                freqMap.put(a[i],1);
            }
            else {
                int CurFreq = freqMap.get(a[i]);
                freqMap.put(a[i],CurFreq  + 1);
                if(CurFreq+1 > size/2) {
                    return a[i];
                }
            }
        }
        return -1;
    }
}
