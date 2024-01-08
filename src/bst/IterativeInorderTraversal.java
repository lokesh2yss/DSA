package bst;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;

public class IterativeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(13);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n3.left = n7;
        n3.right = n8;
        inorderPrint(root);
        System.out.println();
        iterativeInorderTraversal(root);
        System.out.println();
        //root = delete(root, 3);
        inorderPrint(root);
    }
    static void iterativeInorderTraversal(TreeNode root) {
        if(root == null) return;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            cur = node.right;
        }
    }
    static void inorderPrint(TreeNode root) {
        if(root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val+" ");
        inorderPrint(root.right);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
}
