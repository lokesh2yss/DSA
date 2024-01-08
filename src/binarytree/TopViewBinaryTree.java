package binarytree;

import java.util.*;


public class TopViewBinaryTree {
    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
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
        System.out.println(topViewBinaryTree(root));
    }
    public static List<Integer> topViewBinaryTree(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair p = q.poll();
                int hd = p.hd;
                map.putIfAbsent(hd,p.node.val);
                if(p.node.left != null) {
                    q.offer(new Pair(p.node.left,hd-1));
                }
                if(p.node.right != null) {
                    q.offer(new Pair(p.node.right,hd+1));
                }

            }
        }
        return new ArrayList<>(map.values());
    }

}
