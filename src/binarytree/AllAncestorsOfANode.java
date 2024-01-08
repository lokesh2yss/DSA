package binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllAncestorsOfANode {
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
        System.out.println(allAncestorsOfGivenNode2(root, 8));
    }
    public static ArrayList<Integer> allAncestorsOfGivenNode2(TreeNode root, int  target) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        boolean isFound = isNodeFound(root, target, ans);

        return ans;
    }
    public static boolean isNodeFound(TreeNode root, int target, ArrayList<Integer> ans) {
        if(root == null) return false;
        if(root.val == target) {
            return true;
        }
        boolean isFoundLeft = isNodeFound(root.left, target, ans);
        boolean isFoundRight = isNodeFound(root.right, target, ans);
        if(isFoundLeft || isFoundRight) {
            ans.add(root.val);
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> allAncestorsOfGivenNode(TreeNode root, TreeNode node) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        assignParents(root, parents);
        ArrayList<Integer> ans = new ArrayList<>();
        while(parents.get(node) != null) {
            ans.add(parents.get(node).val);
            node = parents.get(node);
        }
        return ans;
    }
    public static void assignParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if(root == null) return;
        if(root.left != null) {
            parents.put(root.left, root);
        }
        if(root.right != null) {
            parents.put(root.right, root);
        }
        assignParents(root.left, parents);
        assignParents(root.right, parents);
    }
}
