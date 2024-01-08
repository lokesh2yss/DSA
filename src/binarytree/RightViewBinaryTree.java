package binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class RightViewBinaryTree {
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
        System.out.println(rightView(root));
    }
    public static ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        rightViewHelper(root, ans, 0);
        return ans;
    }
    public static void rightViewHelper(TreeNode root, ArrayList<Integer> ans, int level) {
        if(root == null) return;
        if(level >= ans.size()) {
            ans.add(root.val);
        }
        rightViewHelper(root.right, ans, level+1);
        rightViewHelper(root.left, ans, level+1);

    }
}
