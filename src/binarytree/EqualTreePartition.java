package binarytree;

public class EqualTreePartition {
    public static boolean checkEqualTree(TreeNode root) {
        int totalTreeSum = sumSubTree(root);
        int halfSum = totalTreeSum/2;
        return isHalfSumSubTreePresent(root, halfSum);

    }
    public static boolean isHalfSumSubTreePresent(TreeNode root, int sum) {
        if(root == null) return false;
        int totalSum = sumSubTree(root);
        if(totalSum == sum) return true;
        return isHalfSumSubTreePresent(root.left, sum) || isHalfSumSubTreePresent(root.right, sum);
    }
    public static int sumSubTree(TreeNode root) {
        if(root==null) return 0;
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = sumSubTree(root.left);
        int rightSum = sumSubTree(root.right);
        return root.val + leftSum + rightSum;
    }
}
