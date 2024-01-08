package binarytree;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root)
    {
        if(root==null) return true;
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        if(Math.abs(heightLeft - heightRight) <=1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
    public static int height(TreeNode root) {
        if(root==null) return 0;
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        return Math.max(heightLeft, heightRight) + 1;
    }
}
