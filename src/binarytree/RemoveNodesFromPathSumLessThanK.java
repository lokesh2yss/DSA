package binarytree;

public class RemoveNodesFromPathSumLessThanK {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null)
            return root;

        if(root.left == null && root.right == null)
            return root.val < limit ? null : root;

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        if(root.left == null && root.right == null) return null;
        return root;

    }
}
