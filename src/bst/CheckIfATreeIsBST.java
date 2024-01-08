package bst;

public class CheckIfATreeIsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(2);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        //n5.left = n6;
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
    public static boolean isBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
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
