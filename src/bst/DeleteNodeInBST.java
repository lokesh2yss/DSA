package bst;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n2 = new TreeNode(3);
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
        n3.right = n8;
        inorderPrint(root);
        System.out.println();
        root = delete(root, 3);
        inorderPrint(root);
    }
    static TreeNode delete(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val) {
            root.right = delete(root.right, key);
        }
        else if(key < root.val) {
            root.left = delete(root.left, key);
        }
        else {
            //key matches with root.val
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            TreeNode successor = findSuccessor(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);

        }
        return root;
    }
    static TreeNode findSuccessor(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp;
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
