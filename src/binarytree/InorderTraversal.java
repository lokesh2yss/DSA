package binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderTraversalHelper(root, ans);
        return ans;
    }
    public static void inOrderTraversalHelper(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        inOrderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inOrderTraversalHelper(root.right, ans);
    }
}
