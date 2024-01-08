package bst;

import com.sun.source.tree.Tree;

public class BSTFromPreorderTraversal {
    public static void main(String[] args) {
        int[] a = {8, 5, 1, 7, 10, 12};
        TreeNode root = createBSTFromPreorderTraversal(a, 0, a.length-1);
        inorderPrint(root);
    }
    static TreeNode createBSTFromPreorderTraversal(int[] a, int l, int r) {
        if(l > r) return null;
        TreeNode root = new TreeNode(a[l]);
        int i = l+1;
        for(;i<=r;i++) {
            if(a[i] > a[l]) break;
        }
        root.left = createBSTFromPreorderTraversal(a, l+1, i-1);
        root.right = createBSTFromPreorderTraversal(a, i, r);
        return root;
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
