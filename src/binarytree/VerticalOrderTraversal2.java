package binarytree;

import java.util.*;

public class VerticalOrderTraversal2 {
    class Pair {
        TreeNode root;
        int row;
        int col;

        Pair(TreeNode node, int rw, int cl) {
            root = node;
            row = rw;
            col = cl;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0,0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair p = q.poll();
                TreeNode tn = p.root;
                int row = p.row;
                int col = p.col;
                if(!map.containsKey(row)) {
                    map.put(row, new TreeMap<>());
                }
                if(!map.get(row).containsKey(col)) {
                    map.get(row).put(col, new PriorityQueue<>());
                }
                map.get(row).get(col).offer(tn.val);
                if(tn.left!= null) {
                    q.offer(new Pair(tn.left, row-1, col+1));
                }
                if(tn.right!= null) {
                    q.offer(new Pair(tn.right, row+1, col+1));
                }
            }

        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> entry: map.values()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(PriorityQueue<Integer> pq: entry.values()) {
                while(!pq.isEmpty()) {
                    tmp.add(pq.poll());
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
