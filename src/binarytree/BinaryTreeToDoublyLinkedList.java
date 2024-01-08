package binarytree;

public class BinaryTreeToDoublyLinkedList {
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
        TreeNode head = convert(root);
        while(root.left!= null) root = root.left;
        head = root;
        while(head != null) {
            System.out.print(head.val+"->");
            head = head.right;
        }
        System.out.println();
    }
    public static TreeNode convert(TreeNode root) {
        if(root == null) return null;
        if(root.left != null) {
            TreeNode left = convert(root.left);
            while (left != null && left.right != null) {
                left = left.right;
            }
            if (left != null) {
                left.right = root;
            }
            root.left = left;
        }
        if(root.right != null) {
            TreeNode right = convert(root.right);
            while (right != null && right.left != null) {
                right = right.left;
            }
            root.right = right;
            if (right != null) {
                right.left = root;
            }
        }
        return root;
    }
}
