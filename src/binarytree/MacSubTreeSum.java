package binarytree;

public class MacSubTreeSum {
    private static int ans;

    private static int subtreeSum(TreeNode root) {
        if(root==null)return 0;
        int p1=subtreeSum(root.left);
        int p2=subtreeSum(root.right);
        ans=Math.max(ans,root.val+p1+p2);
        return root.val+p1+p2;
    }

    public static int findMaxSubtree(TreeNode root) {
        ans=Integer.MIN_VALUE;
        subtreeSum(root);
        return ans;
    }
}
