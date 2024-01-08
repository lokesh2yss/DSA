package bst;

public class SearchInSBT {
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
        System.out.println(search(root, 60));
    }
    static boolean search(TreeNode root, int key) {
        if(root == null) return false;
        if(key > root.val) {
            return search(root.right, key);
        }
        else if(key < root.val) {
            return search(root.left, key);
        }
        return true;
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
