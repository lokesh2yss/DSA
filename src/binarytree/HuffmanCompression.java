package binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCompression {
    static class Node {
        Character ch;
        int freq;
        Node left;
        Node right;
        public Node(Character c, int freq) {
            this.ch = c;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }
        public Node(Character c, int freq, Node left, Node right) {
            this.ch = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
    class MyComparator implements Comparator<Node> {
        public int compare(Node x, Node y)
        {
            if(x.freq == y.freq) return 1;
            return x.freq - y.freq;
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        PriorityQueue<Node> pq = new PriorityQueue<>(new MyComparator());
        for(int i=0;i<N;i++) {
            Node node = new Node(S.charAt(i), f[i]);
            pq.offer(node);
        }
        while(pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sumFreq = left.freq + right.freq;
            Node n3 = new Node('-', sumFreq,left, right);
            pq.offer(n3);
        }
        Node root = pq.poll();
        //print NLR preorder traversal of the tree
        ArrayList<String> ans = new ArrayList<>();
        preorderTraversal(root, ans, "");
        return ans;
    }
    public void preorderTraversal(Node root, ArrayList<String> ans, String code) {
        //if(root == null) return;
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            ans.add(code);
            return;
        }
        preorderTraversal(root.left, ans, code+"0");
        preorderTraversal(root.right, ans, code+"1");
    }

}
