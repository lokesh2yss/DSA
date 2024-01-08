package binarytree;

import java.util.*;
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
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        TreeNode root = n1;
        root.left = n2;
        root.right =n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        System.out.println(verticalTraversal(root));
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
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
