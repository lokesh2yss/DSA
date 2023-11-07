package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Integers123only {
    public static List<Integer> find123Digits(int[] arr, int n)
    {
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(contains123(arr[i])) {
                ans.add(arr[i]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static boolean contains123(int a) {
        if(contains(a,1) && contains(a, 2) && contains(a,3)) {
            return true;
        }
        return false;
    }
    public static boolean contains(int a, int digit) {
        while(a>0) {
            if(a%10 == digit) {
                return true;
            }
            a = a/10;
        }
        return false;
    }
}
