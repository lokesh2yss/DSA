package heapanddisjointset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a, b) -> b.diff -a.diff);
        int n = arr.length;
        for(int i=0;i<n;i++) {
            Item item = new Item(arr[i], Math.abs(arr[i]-x));
            maxHeap.offer(item);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll().value);
        }
        Collections.sort(ans);
        return ans;
    }
    class Item {
        int value;
        int diff;
        public Item(int value, int diff) {
            this.value = value;
            this.diff = diff;
        }
    }
}
