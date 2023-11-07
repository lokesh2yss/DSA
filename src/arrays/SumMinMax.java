package arrays;

import java.util.List;

public class SumMinMax {
    public static long sumMaxMin(List<Long> nums) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int i=0; i< nums.size(); i++) {
            max = Math.max(max, nums.get(i));
            min = Math.min(min,nums.get(i));
        }
        return max+min;


    }
}
