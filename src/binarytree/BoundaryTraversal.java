package binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(boundary(root));

    }
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
        else {
            rightBoundary = new ArrayList<>();
        }
        System.out.println(leftBoundary);
        System.out.println(leafNodes);
        System.out.println(rightBoundary);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(leftBoundary);
        //leafNodes.remove(0);
        if(leafNodes.size()>=1) {
            //leafNodes.remove(leafNodes.size()-1);
        }
        ans.addAll(leafNodes);
        if(rightBoundary.size() > 0) {
            rightBoundary.remove(0);
        }
        Collections.reverse(rightBoundary);
        ans.addAll(rightBoundary);
        return ans;
    }
    public static void leftSubTreeTraversal(TreeNode root, ArrayList<Integer> leftBoundary) {
        if(root == null) return;
        leftBoundary.add(root.val);
        if(root.left != null) {
            leftSubTreeTraversal(root.left, leftBoundary);
        }else {
            //leftSubTreeTraversal(root.right, leftBoundary);
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
        rightBoundary.add(root.val);
        if(root.right != null) {
            rightSubTreeTraversal(root.right, rightBoundary);
        }else {
            //rightSubTreeTraversal(root.left, rightBoundary);
        }
    }
}
