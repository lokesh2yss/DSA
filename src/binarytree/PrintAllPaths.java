package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        binaryTreePathsHelper(root, ans, root.val+"");
        return ans;
    }
    public static void binaryTreePathsHelper(TreeNode root, List<String> ans, String path) {
        if(root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        if(root.left != null) {
            binaryTreePathsHelper(root.left, ans, path+"->"+root.left.val);
        }
        if(root.right != null) {
            binaryTreePathsHelper(root.right, ans, path+"->"+root.right.val);
        }

    }
}
