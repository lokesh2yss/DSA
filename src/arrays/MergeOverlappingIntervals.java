package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        if(intervals.length ==0 || intervals == null) {
            return ans.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] i: intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                ans.add(new int[] {start, end});
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[0][]);

    }
}
