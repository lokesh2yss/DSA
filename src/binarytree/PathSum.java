package binarytree;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            if(targetSum == 0) {
                return true;
            }
            return false;
        }
        boolean hasPathSumLeft = hasPathSum(root.left, targetSum - root.val);
        boolean hasPathSumRight = hasPathSum(root.right, targetSum - root.val);
        return hasPathSumLeft || hasPathSumRight;
    }
}
