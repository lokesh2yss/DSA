package bst;

import java.util.ArrayDeque;

public class TwoSumInSBTEfficient {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(13);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n3.left = n7;
        n3.right = n8;
        System.out.println(twoSumInBST(root, 8));
    }
    static boolean twoSumInBST(TreeNode root, int target) {
        if(root == null) return false;
        TreeNode cur1 = root, cur2 = root;
        int val1 = 0, val2 =0;
        boolean loop1 = false, loop2 = false;
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        while(true) {
            while(loop1 == false) {
                if(cur1 != null) {
                    stack1.push(cur1);
                    cur1 = cur1.left;
                }
                else {
                    if(stack1.isEmpty()) {
                        loop1 = true;
                    }else {
                        TreeNode node = stack1.pop();
                        val1 = node.val;
                        cur1 = node.right;
                        loop1 = true;
                    }
                }
            }
            while(loop2 == false) {
                if(cur2 != null) {
                    stack2.push(cur2);
                    cur2 = cur2.right;
                }else {
                    if(stack2.isEmpty()) {
                        loop2 = true;
                    }else {
                        TreeNode node = stack2.pop();
                        val2 = node.val;
                        cur2 = node.left;
                        loop2 = true;
                    }
                }
            }
            if(val1 != val2 && val1+val2 == target) {
                return true;
            }
            else if(val1+val2 > target) {
                loop2 = false;
            }
            else if(val1+val2 < target) {
                loop1 = false;
            }
            if(val1 >= val2) return false;
        }
    }
    static void inorderPrint(TreeNode root) {
        if(root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val+" ");
        inorderPrint(root.right);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
}
