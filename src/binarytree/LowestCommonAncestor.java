package binarytree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        TreeNode root = n1;
        root.left = n2;
        root.right =n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        System.out.println(lowestCommonAncestor(root, 8, 2));
    }
    public static int lowestCommonAncestor(TreeNode root, int n1, int n2) {
        if(root == null) return -1;
        if(root.val == n1 || root.val == n2) return root.val;
        int lcaLeft = lowestCommonAncestor(root.left, n1, n2);
        int lcaRight = lowestCommonAncestor(root.right, n1, n2);
        if(lcaLeft== -1) return lcaRight;
        if(lcaRight==-1) return lcaLeft;

        return root.val;
    }
}
