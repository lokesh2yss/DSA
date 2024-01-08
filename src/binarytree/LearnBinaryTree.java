package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LearnBinaryTree {
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
        /*inOrderTraversal(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        System.out.println(maxInBinaryTree(root));
        System.out.println(minInBinaryTree(root));
        System.out.println(heightOfATree(root));*/
        System.out.println(levelTraversal(root));
    }
    public static List<List<Integer>> levelTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++) {
                Node cur = q.poll();
                tmp.add(cur.data);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            ans.add(tmp);
        }
        return ans;
    }
    public static ArrayList<Integer> rightViewOfTree2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        //ans.add(root.data);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if(i == size-1) {
                    ans.add(cur.data);
                }
            }
        }
        return ans;
    }
    public static ArrayList<Integer> rightViewOfTree(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        rightViewOfTreeHelper(root, ans, 0);
        return ans;
    }
    public static void rightViewOfTreeHelper(Node root, ArrayList<Integer> ans, int level) {
        if(root == null) return;
        if(ans.size() == level) {
            ans.add(root.data);
        }
        rightViewOfTreeHelper(root.right, ans, level+1);
        rightViewOfTreeHelper(root.left, ans, level+1);

    }
    public static int heightOfATree(Node root) {
        if(root == null) return 0;
        int heightLeft = heightOfATree((root.left));
        int heightRight = heightOfATree((root.right));
        return 1 + Math.max(heightLeft, heightRight);
    }
    public static int minInBinaryTree(Node root) {
        if(root == null) return Integer.MAX_VALUE;
        int leftMin = minInBinaryTree(root.left);
        int rightMin = minInBinaryTree(root.right);
        int min1 = Math.min(leftMin, rightMin);
        int min = Math.min(min1, root.data);
        return min;
    }
    public static int maxInBinaryTree(Node root) {
        if(root == null) return 0;
        int leftMax = maxInBinaryTree(root.left);
        int rightMax = maxInBinaryTree(root.right);
        int max1 = Math.max(leftMax, rightMax);
        int max = Math.max(max1, root.data);
        return max;
    }
    public static void postOrderTraversal(Node root) {
        if(root!=null && root.left!=null) {
            postOrderTraversal(root.left);
        }
        if(root!=null && root.right !=null) {
            postOrderTraversal(root.right);
        }
        if(root!=null) {
            System.out.print(root.data+" ");
        }
    }
    public static void preOrderTraversal(Node root) {
        if(root!=null) {
            System.out.print(root.data+" ");
        }
        if(root.left!=null) {
            preOrderTraversal(root.left);
        }
        if(root.right !=null) {
            preOrderTraversal(root.right);
        }
    }
    public static void inOrderTraversal(Node root) {
        if(root!= null && root.left!=null) {
            inOrderTraversal(root.left);
        }
        if(root!=null) {
            System.out.print(root.data+" ");
        }
        if(root!=null && root.right !=null) {
            inOrderTraversal(root.right);
        }
    }
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
}

