package binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class TreeBoundaryTraversal {
    public static ArrayList<Integer> boundary(TreeNode root) {
        if(root == null) return null;
        ArrayList<Integer> leftBoundary = new ArrayList<>();
        ArrayList<Integer> leafNodes = new ArrayList<>();
        ArrayList<Integer> rightBoundary = new ArrayList<>();
        if(root.left != null) {
            leftBoundary.add(root.val);
            leftSubTreeTraversal(root.left, leftBoundary);
        }
        else {
            leftBoundary.add(root.val);
        }
        findLeafNodes(root, leafNodes);
        if(root.right != null) {
            rightSubTreeTraversal(root.right, rightBoundary);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(leftBoundary);

        ans.addAll(leafNodes);

        Collections.reverse(rightBoundary);
        ans.addAll(rightBoundary);
        return ans;
    }
    public static void leftSubTreeTraversal(TreeNode root, ArrayList<Integer> leftBoundary) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        leftBoundary.add(root.val);
        if(root.left != null) {
            leftSubTreeTraversal(root.left, leftBoundary);
        }else {
            leftSubTreeTraversal(root.right, leftBoundary);
        }
    }
    public static void findLeafNodes(TreeNode root, ArrayList<Integer> leafNodes) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            leafNodes.add(root.val);
        }
        findLeafNodes(root.left, leafNodes);
        findLeafNodes(root.right, leafNodes);
    }
    public static void rightSubTreeTraversal(TreeNode root, ArrayList<Integer> rightBoundary) {
        if(root==null) return;
        if(root.left == null && root.right == null) return;
        rightBoundary.add(root.val);
        if(root.right != null) {
            rightSubTreeTraversal(root.right, rightBoundary);
        }else {
            rightSubTreeTraversal(root.left, rightBoundary);
        }
    }
}
