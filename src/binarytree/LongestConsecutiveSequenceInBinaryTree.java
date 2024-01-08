package binarytree;

public class LongestConsecutiveSequenceInBinaryTree {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return -1;
        int length1 = 1 + longestConsecutiveHelper(root.left, root.val);
        int length2 = 1 + longestConsecutiveHelper(root.right, root.val);
        return Math.max(length1,length2);
    }
    public int longestConsecutiveHelper(TreeNode root, int val) {
        if(root == null) return 0;
        if(root.val == val +1 ) {
            int length1 = 1 + longestConsecutiveHelper(root.left, root.val);
            int length2 = 1 + longestConsecutiveHelper(root.right, root.val);
            return Math.max(length1,length2);
        }
        else {
            return 0;
        }
    }
}
