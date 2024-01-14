package queue;
import java.util.*;
public class CardRotation {
    ArrayList<Integer> rotation(int n){
        // Code Here
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] arr = new int[1001];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        int i=1;
        while(!q.isEmpty()){
            int j=0;
            while(j<i){
                int x = q.peek();
                q.poll();
                q.add(x);
                j++;
            }
            int x = q.peek();
            if(arr[x] != 0){
                res.add(-1);
                return res;
            }
            arr[x] = i;
            q.poll();
            i++;
        }
        for(i=1; i<=n; i++)
            res.add(arr[i]);
        return res;
    }
}
