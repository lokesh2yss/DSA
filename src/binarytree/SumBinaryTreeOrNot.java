package binarytree;

public class SumBinaryTreeOrNot {
    public static boolean isSumTree(TreeNode root) {
        if(root == null) return true;
        if(root.left==null && root.right == null) {
            return true;
        }
        int sum1 = sum(root.left);
        int sum2 = sum(root.right);
        int sum  = sum1 + sum2;
        return sum==root.val && isSumTree(root.left) && isSumTree(root.right);
    }
    public static int sum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return root.val + leftSum + rightSum;
    }
}
