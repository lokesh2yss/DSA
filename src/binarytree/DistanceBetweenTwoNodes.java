package binarytree;

public class DistanceBetweenTwoNodes {
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
        System.out.println(distanceBetweenTwoNodes(root, n7,n7));
    }
    public static int distanceBetweenTwoNodes(TreeNode root, TreeNode n1, TreeNode n2) {
        TreeNode lca = lowestCommonAncestor(root, n1.val, n2.val);
        int n1Dist = distanceFromRoot(lca, n1.val, 0);
        int n2Dist = distanceFromRoot(lca, n2.val, 0);
        return n1Dist + n2Dist;

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, int n1, int n2) {
        if(root == null) return null;
        if(root.val == n1 || root.val == n2) return root;
        TreeNode lcaLeft = lowestCommonAncestor(root.left, n1, n2);
        TreeNode lcaRight = lowestCommonAncestor(root.right, n1, n2);
        if(lcaLeft== null) return lcaRight;
        if(lcaRight== null) return lcaLeft;

        return root;
    }
    public static int distanceFromRoot(TreeNode root, int a, int level) {
        if(root == null) return 0;
        if(root.val == a) return level;
        int distLeft = distanceFromRoot(root.left, a, level+1);
        int distRight = distanceFromRoot(root.right, a, level+1);
        if(distLeft ==0) return distRight;
        if(distRight==0) return distLeft;
        return 0;
    }
}
