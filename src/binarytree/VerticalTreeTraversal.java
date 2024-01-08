package binarytree;

import java.util.*;

public class VerticalTreeTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        Node root = n1;
        root.left = n2;
        root.right =n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        System.out.println(verticalTraversal(root));

    }
    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        q.offer(new Pair(root,0));
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair cur = q.poll();
                int hd = cur.horizontalDist;
                if (map.get(hd) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur.node.data);
                    map.put(hd,list);
                } else {
                    ArrayList<Integer> list = map.get(hd);
                    list.add(cur.node.data);
                    map.put(hd, list);
                }
                if(cur.node.left != null) {
                    q.offer(new Pair(cur.node.left, cur.horizontalDist-1));
                }
                if(cur.node.right != null) {
                    q.offer(new Pair(cur.node.right, cur.horizontalDist+1));
                }

            }
            level++;
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
    static class Pair {
        Node node;
        int horizontalDist;
        public Pair(Node n, int hd) {
            this.node = n;
            this.horizontalDist = hd;
        }
    }
}
