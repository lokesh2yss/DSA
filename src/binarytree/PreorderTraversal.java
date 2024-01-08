package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversalHelper(root, ans);
        return ans;
    }
    public static void preorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if(root==null) return;
        ans.add(root.val);
        preorderTraversalHelper(root.left,ans);
        preorderTraversalHelper(root.right,ans);
    }
}
