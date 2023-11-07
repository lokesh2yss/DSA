package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerContainingOnly123 {
    public static List<Integer> find123Digits(int[] arr, int n)
    {
        List<Integer> ans = new ArrayList<>();

        boolean isPresent = false;
        for(int i=0; i<n;i++) {
            String str = Integer.toString(arr[i]);
            if(str.contains("1") && str.contains("2") && str.contains("3") ) {
                ans.add(arr[i]);
                isPresent = true;
            }
        }
        Collections.sort(ans);
        return ans;


    }
}
