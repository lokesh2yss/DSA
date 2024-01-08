package bst;

public class InsertInBST {
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
        inorderPrint(root);
        System.out.println();
        root = insert(root, 2);
        inorderPrint(root);
    }

    static TreeNode insert(TreeNode root, int key) {
        if(root == null) {
            return new TreeNode(key);
        }
        if(key > root.val) {
            root.right = insert(root.right, key);
        }
        else if(key < root.val) {
            root.left = insert(root.left, key);
        }
        return root;
    }
    static void inorderPrint(TreeNode root) {
        if(root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val+" ");
        inorderPrint(root.right);
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
