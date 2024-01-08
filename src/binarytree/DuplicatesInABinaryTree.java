package binarytree;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInABinaryTree {
    public static boolean hasDuplicateValues(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        return hasDuplicateValuesHelper(root, set);
    }
    public static boolean hasDuplicateValuesHelper(TreeNode root, Set<Integer> set) {
        if(root == null) return false;
        if(set.contains(root.val)) return true;
        set.add(root.val);
        return hasDuplicateValuesHelper(root.left, set) || hasDuplicateValuesHelper(root.right, set);
    }
}
