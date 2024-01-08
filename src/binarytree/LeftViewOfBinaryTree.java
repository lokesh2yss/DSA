package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
    public static List<Integer> leftView(TreeNode root) {
        //DLR
        List<Integer> ans = new ArrayList<>();
        leftViewHelper(root, ans, 0);
        return ans;
    }
    public static void leftViewHelper(TreeNode root, List<Integer> ans, int level) {
        if(root == null) return;
        if(level >= ans.size()) {
            ans.add(root.val);
        }
        leftViewHelper(root.left, ans, level+1);
        leftViewHelper(root.right, ans, level+1);
    }
}
