package bst;

public class InorderPredecessor {
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
        TreeNode successor = inorderSuccessor(root, 13, null);
        inorderPrint(root);
        System.out.println();
        if(successor != null) {
            System.out.println(successor.val);
        }
        else {
            System.out.println("successor not found");
        }
    }
    static TreeNode inorderSuccessor(TreeNode root, int key, TreeNode successor) {
        if(root == null) return successor;
        if(key > root.val) {
            return inorderSuccessor(root.right, key, successor);
        }
        if(key < root.val) {
            return inorderSuccessor(root.left, key, root);
        }
        if(root.right == null) {
            return successor;
        }
        return findSuccessor(root.right);
    }
    static TreeNode findSuccessor(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    static TreeNode inorderPredecessor(TreeNode root, int key, TreeNode predecessor) {
        if(root == null) return null;
        if(key > root.val) {
            return inorderPredecessor(root.right, key, root);
        }
        if(key < root.val) {
            return inorderPredecessor(root.left, key, predecessor);
        }
        if(root.left == null) {
            return predecessor;
        }else {
            return findPredecessor(root.left);
        }
    }
    static TreeNode findPredecessor(TreeNode root) {
        while(root.right != null) {
            root = root.right;
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
