package bst;

public class InsertionInAVLTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root = insertInAVLTree(root, 4);
        root = insertInAVLTree(root, 3);
        root = insertInAVLTree(root, 2);
        root = insertInAVLTree(root,1);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        /*TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(13);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n3.left = n7;
        n3.right = n8;*/
    }
    static int height(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = root.left==null?0:root.left.height;
        int rightHeight = root.right==null?0:root.right.height;
        return Math.max(leftHeight, rightHeight) +1;
    }
    static TreeNode insertInAVLTree(TreeNode root, int key) {
        if(root == null) {
            return new TreeNode(key);
        }
        if(key > root.val) {
            root.right = insertInAVLTree(root.right, key);
        }
        else if(key < root.val) {
            root.left = insertInAVLTree(root.left, key);
        }
        else {
            return root;
        }
        root.height = height(root);
        int hb = height(root.left) - height(root.right);
        if(hb > 1 && key < root.left.val) {

            //left-left case
            return rightRotation(root);
        }
        if(hb < -1 && key > root.right.val) {
            //right-right case
            return leftRotation(root);
        }
        if(hb > 1 && key > root.left.val) {
            //left-right case
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        if(hb < -1 && key < root.right.val) {
            //right-left case
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }
    static TreeNode leftRotation(TreeNode x) {
        TreeNode y = x.right;
        TreeNode B = y.left;

        x.right = B;
        y.left = x;

        x.height = height(x);
        y.height = height(y);

        return y;
    }
    static TreeNode rightRotation(TreeNode x) {
        TreeNode y = x.left;
        TreeNode C = y.right;

        y.right = x;
        x.left = C;

        x.height = height(x);
        y.height = height(y);

        return y;
    }
    static void inorderPrint(TreeNode root) {
        if(root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val+" ");
        inorderPrint(root.right);
    }
    static class TreeNode {
        int val, height;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.val = data;
            this.height = 1;
        }
    }
}
