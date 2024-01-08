package bst;

import arrays.TrappedRainWater;
import com.sun.source.tree.Tree;

public class BalancedBSTFromSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5 ,6, 7, 8};
        TreeNode root = createBalancedBSTFromSortedArray(a, 0, a.length-1);
        inorderPrint(root);
    }
    static TreeNode createBalancedBSTFromSortedArray(int[] a, int l, int r) {
        if(l > r) return null;
        int m = l + (r-l)/2;
        TreeNode root = new TreeNode(a[m]);
        root.left = createBalancedBSTFromSortedArray(a, l, m-1);
        root.right = createBalancedBSTFromSortedArray(a, m+1, r);
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
