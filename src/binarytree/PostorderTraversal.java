package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        return ans;
    }
    public static void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        postorderTraversalHelper(root.left, ans);
        postorderTraversalHelper(root.right, ans);
        ans.add(root.val);
    }
}
