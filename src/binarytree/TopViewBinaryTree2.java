package binarytree;

import com.sun.source.tree.Tree;

import java.util.*;

public class TopViewBinaryTree2 {
    static class Pair {
        TreeNode node;
        int hd;
        public Pair(TreeNode n, int hd) {
            this.node = n;
            this.hd = hd;
        }
    }
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
        System.out.println(topView(root));
    }
    public static ArrayList<Integer> topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair p = q.poll();
                int hd = p.hd;
                TreeNode node = p.node;
                map.putIfAbsent(hd, node.val);
                if(node.left != null) {
                    q.offer(new Pair(node.left, hd-1));
                }
                if(node.right != null) {
                    q.offer(new Pair(node.right, hd+1));
                }
            }
        }
        return new ArrayList<Integer>(map.values());
    }
}
