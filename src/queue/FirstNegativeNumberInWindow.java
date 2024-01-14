package queue;
import java.util.*;
public class FirstNegativeNumberInWindow {
    public List<Integer> firstNegative(int[] arr, int n, int k)
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int i =0;
        while(i<k) {
            if(arr[i] <0) {
                dq.offerLast(arr[i]);
            }
            i++;
        }
        for(;i<n;i++) {
            if(!dq.isEmpty()) {
                ans.add(dq.getFirst());
            }
            else {
                ans.add(0);
            }
            if(!dq.isEmpty() && arr[i-k] == dq.getFirst()) {
                dq.pollFirst();
            }
            if(arr[i] < 0) {
                dq.offerLast(arr[i]);
            }
        }
        if(dq.isEmpty()) {
            ans.add(0);
        }
        else {
            ans.add(dq.peekFirst());
        }
        return ans;
    }
}
